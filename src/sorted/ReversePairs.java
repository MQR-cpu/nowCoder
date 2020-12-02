package sorted;


//用归并排序的思想  解决逆数对
public class ReversePairs {

    public static int solution(int[] nums) {
        return mergeSort(nums, 0, nums.length-1);
    }

    private static int mergeSort(int[] nums, int l, int r) {

        int answer = 0;

        if(l >= r)
            return 0;

        int mid = (l + r) / 2;
        int a = mergeSort(nums, l, mid);
        int b = mergeSort(nums, mid + 1, r);

        int c = merge(nums, l, mid, r);

        return a + b + c;
    }

    private static int merge(int[] nums, int l, int mid, int r) {

        int count = 0;

        int[] temp = new int[r-l+1];
        for (int i = l; i <= r; i++) {
            temp[i - l] = nums[i];
        }

        int i = 0;
        int j = mid-l+1;

        //新数组的中点和有边界
        int mm = mid -l;
        int rr = r - l;

        for (int k = l; k <= r; k++) {
            if (i > mm) {
                nums[k] = temp[j];
                j++;
            } else if (j > rr) {
                nums[k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {

                nums[k] = temp[i];
                i++;
            } else if (temp[i] > temp[j]) {
                nums[k] = temp[j];
                int a = mm - i + 1;

                count += a;
                j++;
            }
        }


        return count;
    }

    public static void main(String[] args) {
        int[] nums = {7, 5, 6, 4};
        int solution = ReversePairs.solution(nums);
        System.out.println(solution);
    }
}
