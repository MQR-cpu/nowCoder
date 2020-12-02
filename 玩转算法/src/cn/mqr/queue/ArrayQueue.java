package cn.mqr.queue;

import cn.mqr.array.Array;

public class ArrayQueue<E> implements Queue<E> {

    private Array<E> queue;

    public ArrayQueue(int capacity) {
        queue = new Array<>(capacity);
    }

    public ArrayQueue() {
        queue = new Array<>();
    }

    @Override
    public void enqueue(E e) {
        queue.addLast(e);
    }

    @Override
    public E dequeue() {
        return queue.removeFirst();
    }

    @Override
    public E getFront() {
        return queue.getFirst();
    }

    @Override
    public int getSize() {
        return queue.getSize();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int getCapacity() {
        return queue.getCapacity();
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("Queue : Front[");
        for (int i = 0; i < queue.getSize(); i++) {
            sb.append(queue.get(i));
            if (i != queue.getSize()-1) {
                sb.append(",");
            }
        }
        sb.append("]Tail");
        return sb.toString();
    }
}
