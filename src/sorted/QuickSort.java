package sorted;

import cn.mqr.array.Array;

import java.util.Arrays;

public class QuickSort {

    public static void quickSort(int[] arr) {
        __quickSort2(arr, 0, arr.length - 1);
    }

    private static void __quickSort(int[] arr, int l, int r) {

        if(l >= r)
            return;

        int p = partition(arr, l, r);
        __quickSort(arr,l,p-1);
        __quickSort(arr,p+1,r);
    }

    private static void __quickSort2(int[] arr, int l, int r) {

        if(l >= r)
            return;

        int p = partition2(arr, l, r);
        __quickSort2(arr,l,p-1);
        __quickSort2(arr,p+1,r);
    }

    //使得 arr[l,i) <= v >=(j,r]
    private static int partition2(int[] arr, int l, int r) {
        int random =l + (int)(Math.random()*(r-l+1));

        swap(arr, random, l);
        int v = arr[l];

        int i = l+1;
        int j = r;

        while (true) {
            //短路&& 先判断i,j是否合法
            while(i <= r && arr[i] < v ) i++;
            while(j >= l+1 && arr[j] > v  ) j--;
            if(i > j)
                break;
            swap(arr,i,j);
            //交换完继续前进
            i++;
            j--;
        }
        //完成后交换 v 和j  arr[j] 比 v小所以把j交换到左面
        swap(arr,j,l);
        return j;

    }

    //使得 arr[l,p-1] < arr[p] < arr[p+1,r]
    private static int partition(int[] arr, int l, int r) {

        int random =l + (int)(Math.random()*(r-l+1));

        swap(arr, random, l);
        int v = arr[l];
        int j = l;
        for (int i = l+1; i <= r; i++) {
            if (arr[i] < v) {
                swap(arr,j+1,i);
                j++;
            }
        }
       swap(arr,l,j);
        return j;
    }

    private static void swap(int[] arr, int a, int b) {
        //要加参数取值判断
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


    public static void main(String[] args) {
        int[] arr = {100,32, 3,4,56,23,1,1,452,45,32,22,2,5,5, 64,64, 23, 234, 643};
        QuickSort.quickSort(arr);
        System.out.println(Arrays.toString(arr));

    }

}
