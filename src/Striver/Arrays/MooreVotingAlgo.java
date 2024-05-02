package Striver.Arrays;

import Striver.Sorting.QuickSort;

public class MooreVotingAlgo {
    public static int majorityElement(int[] nums) {
        int n = nums.length;
        int count = 0;
        int candidate = 0;
        for (int i = 0; i < n; ++i) {
            if (count == 0) {
                candidate = nums[i];
                count++;
            } else {
                if (candidate == nums[i]) {
                    count++;
                } else count--;
            }
        }
        int c = 0;
        for (int i = 0; i < n; i++) {
            if (candidate == nums[i]) c++;
        }
        if (c > n / 2) {
            return candidate;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] num = {3,3,4};

        int elem  = majorityElement(num);
        System.out.println("Element " + elem);
        QuickSort.PrintArr(num);
    }
}
