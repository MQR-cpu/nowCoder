package sorted;

import java.util.Arrays;

public class QuickSortThreeWays {

    private static void sort(int[] arr) {
        quickSort3Ways(arr, 0, arr.length - 1);
    }

    //递归出现堆栈溢出  可能是没有设置返回

    // [l+1,lt] < v  [lt + 1,i)  == v  [gt,r] > v
    private static void quickSort3Ways(int[] arr, int l, int r) {
        if(r - l < 5) {
            InsertionSort.insertionSort(arr, l, r);
            return;
        }
        //partition
        int random =l + (int)(Math.random()*(r-l+1));

        swap(arr, random, l);
        int v = arr[l];

        int lt = l;
        int gt = r + 1;
        int i = l + 1;

        while (i < gt) {
            if (arr[i] < v) {
                swap(arr,lt + 1,i);
                i++;
                lt++;
            }
            else if (arr[i] == v) {
                i++;
            } else if (arr[i] > v) {
                swap(arr,gt-1,i);
                gt--;
            }
        }

        swap(arr,l,lt);


        quickSort3Ways(arr,l,lt-1);
        quickSort3Ways(arr,gt,r);
    }
    private static void swap(int[] arr, int a, int b) {
        //要加参数取值判断
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


    public static void main(String[] args) {
        int[] arr = {12, 1,2,3,4,5,432, 45, 22,0, 4, 5, 32, 34};
        QuickSortThreeWays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
