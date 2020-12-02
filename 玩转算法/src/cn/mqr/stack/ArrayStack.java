package cn.mqr.stack;

import cn.mqr.array.Array;

public class ArrayStack<E> implements Stack<E> {

    private Array<E> data;

    public ArrayStack(int capacity) {
        data = new Array<>(capacity);
    }

    public ArrayStack() {
        data = new Array<>(10);
    }

    @Override
    public E pop() {
        return data.removeLast();
    }

    @Override
    public void push(E e) {
        data.addLast(e);
    }

    @Override
    public int getSize() {
        return data.getSize();
    }

    @Override
    public E peek() {
        return data.getLast();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    public int getCapacity() {
        return data.getCapacity();
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("Stack : [");

        for (int i = 0; i < data.getSize(); i++) {
            sb.append(data.get(i));
            if (i != data.getSize() - 1) {
                sb.append(",");
            }
        }

        sb.append("] top");
        return sb.toString();
    }
}
