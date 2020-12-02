package cn.mqr.bst;

public class Main {
    public static void main(String[] args) {

        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        int[] arr = {5, 2, 3, 7, 8};
        for (int a : arr) {
            bst.add(a);
        }

//        System.out.println(bst);
//        bst.preOrder();
//        System.out.println(";;;;;;;;;");
//        bst.preOrderNR();
        System.out.println(bst);
        bst.delete(8);
        System.out.println(bst);
        bst.preOrderNR();

    }
}
