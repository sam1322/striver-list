package Striver.Arrays;

public class NextPermutation {
    public static void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 1;
        while (i > 0 && nums[i - 1] >= nums[i]) {
            i--;
        }
        if (i ==0) {
            reverse(nums, 0, nums.length - 1);
        } else {
            System.out.println("Yo");
            int j = n - 1;
            for(; j >= i ; --j){
                if(nums[j] > nums[i -1 ])break;
            }
            swap(nums, i - 1, j);
            reverse(nums, i, nums.length - 1);
        }

    }

    public static void reverse(int[] arr, int low, int high) {
        while (low < high) {
            swap(arr, low, high);
            low++;
            high--;
        }
    }

    public static void swap(int[] arr, int low, int high) {
        int t = arr[low];
        arr[low] = arr[high];
        arr[high] = t;
    }

    public static void main(String[] args) {
//        int[] nums = {1, 2, 3};
//        int[] nums = {1, 2,6,4,5};
//        int[] nums = {1, 3, 2};
//        int[] nums = {2,3,1};
        int[] nums = {5,1,1};
        ArrayImpl.printArr(nums);
        nextPermutation(nums);
        ArrayImpl.printArr(nums);

    }
}
