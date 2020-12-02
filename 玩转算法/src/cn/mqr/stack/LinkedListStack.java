package cn.mqr.stack;

import cn.mqr.linkedlist.LinkedList;

public class LinkedListStack<E> implements Stack<E> {

    private LinkedList<E> list;

    public LinkedListStack() {
        list = new LinkedList<>();
    }

    @Override
    public E pop() {
        return list.removeLast();
    }

    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public E peek() {
        return list.getFirst();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public String toString() {
        return toString();
    }
}
