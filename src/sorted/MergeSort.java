package sorted;

import java.util.Arrays;

public class MergeSort {

    public static void sort(int[] arr) {
        __merge(arr, 0, arr.length - 1);
    }

    /**
     * 用递归排序 arr [l,r]
     * @param arr
     * @param l
     * @param r
     */
    private static void __merge(int[] arr, int l, int r) {

        if(l >= r)
            return;
//
//        //当递归到数据量比较小的时候可以用插入排序 （高级排序算法都可以在递归终止条件处优化）
//        if (r - l <= 3) {
//            InsertionSort.insertionSort(arr,l,r);
//            //记得return
//            return;
//        }

        int mid = (l+r)/2;

        __merge(arr,l,mid);
        __merge(arr,mid+1,r);
        //优化  对近乎有序的数据可以加上这个条件
        if (arr[mid] > arr[mid + 1]) {
            merge(arr, l,mid, r);
        }
    }

    private static void merge(int[] arr, int l,int mid, int r) {

        int[] temp = new int[r-l+1];
        for (int i = l; i <= r; i++) {
            temp[i - l] = arr[i];
        }

        int i = 0;
        int j = mid-l+1;

        //新数组的中点和有边界
        int mm = mid -l;
        int rr = r - l;

        for (int k = l; k <= r; k++) {
            if (i > mm) {
                arr[k] = temp[j];
                j++;
            } else if (j > rr) {
                arr[k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {

                arr[k] = temp[i];
                i++;
            } else if (temp[i] > temp[j]) {
                arr[k] = temp[j];
                j++;
            }
        }
    }


    public static void main(String[] args) {
        int[] arr = {7,5,6,4};
        MergeSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }



}
