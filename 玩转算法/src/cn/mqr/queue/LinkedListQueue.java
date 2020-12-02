package cn.mqr.queue;

import cn.mqr.linkedlist.LinkedList;

public class LinkedListQueue<E> implements Queue<E> {

    private class Node {

        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this.e = e;
            next = null;
        }

        public Node() {
            this.e = null;
            this.next = null;
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public LinkedListQueue(){
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void enqueue(E e) {
        if (isEmpty()) {
            Node node = new Node(e);
            head = node;
            tail = node;
        } else {
            Node node = new Node(e);
            tail.next = node;
            tail = node;
        }
        size++;
    }

    //链表要注意 为空 长度为1 时的情况
    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from empty queue");
        }
        Node delNode = head;
        if (head.next == null) {

            tail = null;
        } else {
            head = head.next;
        }
        //防止内存泄漏
        delNode.next = null;
        size--;
        return delNode.e;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("nothing");
        }
        return head.e;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue  Front [ ");
        //链表的头结点在遍历的时候不能变
        Node cur = head;
        while (cur != null) {
            res.append(cur);
            if (cur.next != null) {
                res.append("->");
            }
            cur  = cur.next;
        }
        res.append("] Tail");
        return res.toString();
    }

    public static void main(String[] args) {

        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        for (int i = 0; i < 12; i++) {
            queue.enqueue(i);
        }
        System.out.println(queue);
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        System.out.println(queue);
        System.out.println(queue.getFront());
        System.out.println(queue.dequeue());

    }

}
