package cn.mqr.segmentTree;

public class SegmentTree<E> {

    private Merger<E> merger;
    private E[] tree;
    private E[] data;

    public SegmentTree(E[] arr ,Merger<E> merger) {
        this.merger = merger;
        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        tree = (E[]) new Object[4 * arr.length];
        buildSegmentTree(0,0,data.length-1);
    }
    //在treeIndex的位置创建[l,r]的区间
    private void buildSegmentTree(int treeIndex, int l, int r) {

        if (l == r) {
            tree[treeIndex] = data[l];
            return;
        }

        int leftIndex = leftChild(treeIndex);
        int rightIndex = rightChild(treeIndex);

        int mid = l + (r - l) / 2;
        buildSegmentTree(leftIndex, l, mid);
        buildSegmentTree(rightIndex, mid + 1, r);

        tree[treeIndex] = merger.merger(tree[leftIndex], tree[rightIndex]);
    }


    public E query(int queryL, int queryR) {
        if (queryL > data.length - 1 || queryL < 0 || queryR < 0 || queryR > data.length - 1) {
            throw new IllegalArgumentException("illgel");
        }
        return query(0,0,data.length-1,queryL,queryR);
    }

    //以treeIndex为索引的[l,r]区间内,查询区间queryL,queryR的值
    private E query(int treeIndex, int l, int r, int queryL, int queryR) {

        if (l == queryL && r == queryR) {
            return tree[treeIndex];
        }

        int mid = l + (r - l) / 2;
        int leftChild = leftChild(treeIndex);
        int rightChild = rightChild(treeIndex);

        if (queryL >= mid + 1) {
            return query(rightChild, mid + 1, r, queryL, queryR);
        } else if (queryR <= mid) {
            return query(leftChild,l, mid, queryL, queryR);
        }

        E leftResult = query(treeIndex, l, r, queryL, mid);
        E rightResult = query(treeIndex, l, r, mid + 1, queryR);
        return merger.merger(leftResult, rightResult);
    }

    public int getSize() {
        return data.length;
    }

    public E getIndex(int index) {
        if (0 > index || index >= data.length) {
            throw new IllegalArgumentException("index is illegal");
        }
        return data[index];
    }

    public int leftChild(int index) {
        return 2 * index + 1;
    }

    public int rightChild(int index) {
        return 2 * index + 2;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < tree.length; i++) {
            sb.append(tree[i]);
            if (i < tree.length - 1) {
                sb.append(",");
            }
        }

        sb.append("]");
        return sb.toString();
    }
}
