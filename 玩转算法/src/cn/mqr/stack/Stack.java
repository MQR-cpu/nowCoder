package cn.mqr.stack;

public interface Stack<E> {

    public E pop();

    public void push(E e);

    public int getSize();

    public E peek();

    public boolean isEmpty();
}
