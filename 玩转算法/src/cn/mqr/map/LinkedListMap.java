package cn.mqr.map;

import cn.mqr.linkedlist.LinkedList;

public class LinkedListMap<K,V> implements Map<K,V> {


    private class Node {

        public K key;
        public V value;
        public Node next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            next = null;
        }

        public Node() {
            this.key = null;
            this.value = null;
            this.next = null;
        }
    }


    private Node dummyHead;
    private int size;

    public LinkedListMap() {
        dummyHead = new Node();
        size = 0;
    }

    private Node getNode(K key) {
        Node cur = dummyHead;
        while (cur.next != null) {
            if (cur.next.key.equals(key)) {
                return cur.next;
            }
            cur = cur.next;
        }
        return null;
    }

    @Override
    public void add(K key, V value) {
        if (getNode(key) != null) {
            throw new IllegalArgumentException("key is exist");
        }
        Node node = new Node(key, value, dummyHead.next);
        dummyHead.next = node;
        size ++;
    }

    @Override
    public V remove(K key) {
        Node prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.key.equals(key)) {
                break;
            }
            prev = prev.next;
        }
        if (prev.next != null) {
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size --;
            return delNode.value;
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        return getNode(key) != null;
    }

    @Override
    public V get(K key) {
        return getNode(key)==null ? null : getNode(key).value;
    }

    @Override
    public void set(K key, V value) {
        if (getNode(key) != null) {
            getNode(key).value = value;
        } else {
            throw new IllegalArgumentException("key is not exist");
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

}
