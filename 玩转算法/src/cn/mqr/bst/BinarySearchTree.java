package cn.mqr.bst;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二分搜索树
 * @param <E>
 */
public class BinarySearchTree<E extends Comparable<E>> {

    private class Node{

        public E e;
        public Node left;
        public Node right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BinarySearchTree() {
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {

        root = add2(root,e);
    }

    //向以root为根的二叉树插入节点e
    private void add(Node root, E e) {
       if(root.e.equals(e))
           return;
       if (e.compareTo(root.e) < 0 && root.left == null) {
           root.left = new Node(e);
           size++;
           return;
       }
       if (e.compareTo(root.e) > 0 && root.right == null) {
           root.right = new Node(e);
           size++;
           return;
       }

        if (e.compareTo(root.e)<0)
            add(root.left,e);
        else
            add(root.right,e);
    }

    //返回添加节点后根节点
    private Node add2(Node node, E e) {
        if(node == null){
            size++;
            return new Node(e);
        }

        if (e.compareTo(node.e) < 0) {
            node.left = add2(node.left, e);
        } else if/** 相等时什么也不做*/ (e.compareTo(node.e) > 0) {
            node.right = add2(node.right, e);
        }

        return node;
    }


    private boolean contains(Node root, E e) {
        if (root == null) {
            return false;
        }
        if (e.compareTo(root.e) == 0) {
            return true;
        } else if (e.compareTo(root.e) < 0) {
            return contains(root.left, e);
        }else
        return contains(root.right, e);
    }

    public boolean contains(E e) {
        return contains(root, e);
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {

        if(node == null)
            return;

        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);

    }

    //not recursive
    //深度优先遍历
    public void preOrderNR() {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.e);

            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    //层序遍历  广度优先遍历
    public void levelOrder() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node cur = queue.remove();
            System.out.println(cur.e);
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
    }

    //返回值最小节点
    public Node minimum() {
        return minimum(root);
    }

    public Node delMin() {
        root = delMin(root);
        return minimum();
    }

    public Node delMax() {
        root = delMax(root);
        return maximum();
    }

    //返回删除最小值后的根节点
    private Node delMin(Node node) {

        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size --;
            return rightNode;
        }

        node.left = delMin(node.left);
        return node;
    }
    private Node delMax(Node node) {

        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size --;
            return leftNode;
        }

        node.right = delMax(node.right);
        return node;
    }

    public void delete(E e) {
        root = del(root, e);
    }

    private Node del(Node node, E e) {

        if(node == null)
            return null;

        if (e.compareTo(node.e) < 0) {
             node.left = del(node.left, e);
             return node;
        } else if (e.compareTo(node.e) > 0) {
             node.right = del(node.right, e);
             return node;
        } else {
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size --;
                return rightNode;
            }

            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size --;
                return leftNode;
            }

            Node successor = minimum(node.right);
            successor.left = node.left;
            successor.right = delMin(node.right);
            node.right = node.left = null;
            return successor;
        }
    }

    //
    public Node maximum() {
        return maximum(root);
    }

    private Node maximum(Node node) {
        return minimum(root);
    }

    private Node minimum(Node node) {

        if (node.left == null) {
            return node;
        }

        return minimum(node.left);
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {

        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        generalBstString(root, 0, sb);
        return sb.toString();
    }

    private void generalBstString(Node node, int depth, StringBuilder stringBuilder) {

        if (node == null) {
            stringBuilder.append(soutDepth(depth) + "null\n");
            return;
        }

        stringBuilder.append(soutDepth(depth)+node.e.toString() + "\n");
        generalBstString(node.left,depth+1,stringBuilder);
        generalBstString(node.right,depth+1,stringBuilder);

    }

    private String soutDepth(int depth) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth; ++i) {
            sb.append("-");
        }

        return sb.toString();
    }
}
