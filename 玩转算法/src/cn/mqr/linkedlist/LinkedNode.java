package cn.mqr.linkedlist;

public class LinkedNode {

    private int val;
    private LinkedNode next;

    public LinkedNode(int e) {
        val = e;
        next = null;
    }

    public LinkedNode(int e, LinkedNode next) {
        this.val = e;
        this.next = next;
    }

    public LinkedNode() {

    }

    public void add(int[] arr) {
        this.val = arr[0];
        LinkedNode cur = this;

        for (int i = 1; i < arr.length; i++) {
            LinkedNode node = new LinkedNode(arr[i]);
            cur.next = node;
            cur = cur.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("[");
        LinkedNode cur = this;
        while(cur != null){
            res.append(cur.val);
            if (cur.next != null) {
                res.append("->");
            }
            cur = cur.next;
        }
        res.append("]");
        return res.toString();
    }

    public static void main(String[] args) {
        LinkedNode node = new LinkedNode();
        int[] arr = {12, 1231, 455, 5, 6, 6, 3,1 , 324};
        node.add(arr);
        System.out.println(node);
    }
}
