package cn.mqr.heap;

import cn.mqr.linkedlist.LinkedList;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class LeetCode347 {
    public int[] topKFrequent(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            }else
                map.put(num, 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a, b) -> map.get(a) - map.get(b)
        );

        for (int key : map.keySet()) {
            if (pq.size() < k) {
                pq.add(key);
            } else if (map.get(key) > pq.peek()) {
                pq.remove();
                pq.add(key);
            }
        }

        int[] arr = new int[pq.size()];
        int index = 0;
        while (pq.size() > 0) {
            arr[index++] = pq.remove();
        }

        return arr;

    }
}
