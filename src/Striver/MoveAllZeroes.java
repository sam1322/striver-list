package Striver;

public class MoveAllZeroes {

    public static void moveZeroes(int[] nums) {
        int i = 0;
        int j;
        int n = nums.length;
        while (i < n) {
            while (i < n && nums[i] != 0) i++;
            j = i + 1;
            while (j < n && nums[j] == 0) j++;
            if (i < j && j < n) {
                nums[i] = nums[j];
                nums[j] = 0;
            }
            else{
                i++;
            }
        }
    }

    public static void main(String[] args) {
//        int[] num = {0, 1, 0, 3, 12};
        int[] num = {0};

        int k = 3;
        moveZeroes(num);
        QuickSort.PrintArr(num);
    }
}
