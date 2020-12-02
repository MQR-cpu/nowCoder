package sorted;

//递归计算数组和
public class Sum {

    public static int sum(int[] arr) {
        return sum(arr, arr.length - 1);
    }

    // 计算arr[0,n]
    public static int sum(int[] arr, int n) {
        if(n < 0)
            return 0;

        return arr[n] + sum(arr, n - 1);
    }

    public static void main(String[] args) {
        int[] arr = {100,1, 2, 3, 4, 5,6};
        System.out.println(Sum.sum(arr));
    }
}
