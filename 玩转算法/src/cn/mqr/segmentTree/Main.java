package cn.mqr.segmentTree;

public class Main {
    public static void main(String[] args) {

        Integer[] arr = {1, 2, 3, 4,5};
        SegmentTree<Integer> segmentTree = new SegmentTree<>(arr, (a,b) -> a+b);
        System.out.println(segmentTree.query(0,4));

    }
}
