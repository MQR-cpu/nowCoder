package cn.mqr.heap;

import cn.mqr.array.Array;

public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;
    private int size;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
        size = 0;
    }

    public MaxHeap() {
        data = new Array<>();
        size = 0;
    }

    // heapify 过程
    public MaxHeap(E[] arr) {
        data = new Array<>(arr);
        for (int i = parent(data.getSize() - 1); i <= 0; i--) {
            shiftDown(i);
        }
    }

    public int getSize() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    public int parent(int index) {
        return (index - 1) / 2;
    }

    public int leftChild(int index) {
        return (index * 2) + 1;
    }

    public int rightChild(int index) {
        return (index + 1)*2;
    }

    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    public void siftUp(int k) {

        while (k > 0 && data.get(k).compareTo(data.get(parent(k))) > 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    public E findMax() {
        if (data.getSize() == 0) {
            throw new IllegalArgumentException("heap is empty");
        }
        return data.get(0);
    }

    //取出最大的元素
    public E extractMax() {

        E max = findMax();
        data.swap(0, data.getSize()-1);
        data.removeLast();

        shiftDown(0);

        return max;
    }



    private void shiftDown(int k) {

        while (leftChild(k) < data.getSize()) {
            int j = leftChild(k);
            if (j + 1 < data.getSize() && data.get(j).compareTo(data.get(j + 1)) < 0) {
                j = j +1;
            }
            if (data.get(k).compareTo(data.get(j)) > 0) {
                break;
            }
            data.swap(k,j);
            k = j;
        }
    }

    public void replace(E e) {
        data.set(0,e);
        shiftDown(0);
    }




}
