package cn.mqr.heap;


import java.sql.Array;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        int n = 10000;
        MaxHeap<Integer> heap = new MaxHeap<>();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            heap.add(random.nextInt(n));
        }
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = heap.extractMax();
        }


        for (int i = 0; i +1< n; i++) {
            if (arr[i] < arr[i + 1]) {
                throw new IllegalArgumentException("bad");
            }
        }
        System.out.println(Arrays.toString(arr));
        System.out.println("this heap is yes");
    }
}
