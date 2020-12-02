package cn.mqr.linkedlist;

public class Sum {

    public int sum(int[] arr) {
        return sSum(0, arr);
    }

    private int sSum(int l,int[] arr) {
        if (l == arr.length)
            return 0;
        return arr[l] + sSum(l + 1, arr);
    }

    public static void main(String[] args) {
        Sum a  = new Sum();
        int[] arr = {100,200,300};
        System.out.println(a.sum(arr));
    }
}
