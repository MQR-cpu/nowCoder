package sorted;

import java.util.Arrays;

public class ShellSort {

    public static void shellSort(int[] arr) {
        int N = arr.length;
        int h = 1;
        while (h < N / 3) {
            h = 3*h + 1;
        }
        while (h >=1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && arr[j] < arr[j - h]; j -= h) {
                    swap(arr, j, j - h);
                }
            }
            h = h/3;
        }
    }

    public static void shellSort2(int[] arr) {
        int N = arr.length;
        int h = 1;
        while (h < N / 3) {
            h = 3*h + 1;
        }
        while (h >=1) {
            for (int i = h; i < N; i++) {
                int insert = arr[i];
                int j;
                for (j = i; j >= h && insert < arr[j - h]; j -= h) {
                    arr[j] = arr[j-h];
                }
                arr[j] = insert;
            }
            h = h/3;
        }
    }

    private static void swap(int[] arr, int a, int b) {
        arr[a] = arr[a] + arr[b];
        arr[b] = arr[a] - arr[b];
        arr[a] = arr[a] - arr[b];
    }


    public static void main(String[] args) {
        int[] arr = {324, 32, 56, 265, 624, 33};
        ShellSort.shellSort2(arr);
        System.out.println(Arrays.toString(arr));
    }
}
