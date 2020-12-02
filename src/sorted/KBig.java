package sorted;

import cn.mqr.array.Array;

//数组中第k大的元素
public class KBig {

    public static int solution(int[] arr, int k) {
        return partition(arr, 0, arr.length - 1, arr.length-k);
    }

    //使得 arr[l,p-1] < arr[p] < arr[p+1,r]
    private static int partition(int[] arr, int l, int r,int k) {

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

        if (k == j) {
            return arr[j];
        } else if (k < j) {
            return partition(arr, l, j-1, k);
        } else   {
            return partition(arr, j+1, r, k);
        }

    }

    private static void swap(int[] arr, int a, int b) {
        //要加参数取值判断
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {3,2,3,1,2,4,5,5,6};
        int partition = KBig.solution(arr, 4);
        System.out.println(partition);
    }

}
