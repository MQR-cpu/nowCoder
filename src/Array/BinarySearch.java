package Array;

public class BinarySearch {

    public static int binarySearch(int[] arr, int target) {
        int l = 0;
        int r = arr.length - 1; // 在[l,r]中查找
        //l==r 说明只有一个元素也可以
        while (l <= r) {
            // 为防止整形溢出
            int mid = l + ((r - l) >>> 1 );
            if(arr[mid] == target)
                return mid;
            if (arr[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return -1;
    }

    //改变下查找的边界
    public static int binarySearch2(int[] arr, int target) {
        int l = 0;
        int r = arr.length; // 在[l,r)中查找
        //l==r 说明只有一个元素也可以
        while (l < r) {
            // 为防止整形溢出
            int mid = l + ((r - l) >>> 1 );
            if(arr[mid] == target)
                return mid;
            if (arr[mid] > target) {
                r = mid ;
            } else {
                l = mid + 1;
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(BinarySearch.binarySearch2(arr,1));
    }
}
