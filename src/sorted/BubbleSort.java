package sorted;

import java.util.Arrays;

public class BubbleSort {

    public void bubbleSort(int[] arr) {
        int m = arr.length,n = arr.length;
        //改良点
        boolean isSorted = false;
        for (int i = 0; i < n && !isSorted; i++) {
            isSorted = true;
            for (int j = 0; j + 1 < m; j++) {
                if (arr[j + 1] < arr[j]) {
                    isSorted = false;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            //改良点
           m--;
        }
    }


    public static void main(String[] args) {
        int[] arr = {21, 43, 345, 56, 25, 3, 56};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }


}
