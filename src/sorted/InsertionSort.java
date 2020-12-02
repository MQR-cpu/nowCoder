package sorted;

import java.util.Arrays;

public class InsertionSort {

    public static void insertionSort(int[] arr) {
        insertionSort2(arr,arr.length);
    }


    /**
     * 改良版插入排序   原版swap次数多 一次swap等于三次赋值
     * @param arr
     * @param n
     */
    private static void insertionSort2(int[] arr, int n) {
        for (int i = 1; i < n; i++) {
            int a = arr[i];//要插入的元素
            int j ; //要插入的位置
            for (j = i; j > 0 && arr[j-1] > a; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = a;
        }
    }

    private static void insertionSort(int[] arr, int n) {
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0 ; j--) {
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                } else {
                    break;
                }

            }
        }
    }

    public static void insertionSort(int[] arr, int l,int r) {
        for (int i = l+1; i <= r; i++) {
            for (int j = i; j > l ; j--) {
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                } else {
                    break;
                }

            }
        }
    }

    public static void main(String[] args) {

        int[] arr = {23, 54, 5, 1, 4, 3,44 , 34, 5, 45, 433, 4, 5, 5};
        InsertionSort.insertionSort(arr);

        System.out.println(Arrays.toString(arr));

    }

}
