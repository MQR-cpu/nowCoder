package sorted;

import java.util.Arrays;

public class SelectSort {

    public void selectSorted(int[] arr) {
        selectSorted(arr,arr.length);
    }

    public void selectSorted(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i+1; j < n; j++) {
                if (arr[minIndex] > arr[j]) {
                    swap(arr, j, minIndex);
                }
            }
        }
    }




    /**
     * java 是值传递 不能这么交换数字 可以通过数组进行交换
     * @param a
     * @param b
     */
    private void swap(int a, int b) {
       a = a+b;
       b = a-b;
       a = a-b;
    }

    private void swap(int[] arr, int a, int b) {
        arr[a] = arr[a] + arr[b];
        arr[b] = arr[a] - arr[b];
        arr[a] = arr[a] - arr[b];
    }

    public static void main(String[] args) {
        int[] arr = {123, 4, 5, 6, 14, 132, 3251, 333};

        SelectSort sorted = new SelectSort();
        sorted.selectSorted(arr);
        System.out.println(Arrays.toString(arr));
    }
}
