package Striver.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumSumOfNonAdjacentElements {
    public static int[] dp;

    public static int houseRobber(int index, int[] nums) {
        if (index < 0) return 0;
        if (dp[index] != -1) return dp[index];
        return dp[index] = Math.max(houseRobber(index - 1, nums), houseRobber(index - 2, nums) + nums[index]);
    }

    public static int rob(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return houseRobber(nums.length - 1, nums);
    }

    public static int robDp(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int[] dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1; i < n; ++i) {
            int pick = nums[i];
            int nonPick = dp[i - 1];
            if (i > 1) {
                pick += dp[i - 2];
            }
            dp[i] = Math.max(nonPick, pick);
        }
        return dp[n - 1];
    }

    private static int robDp2(int[] nums) {
        int n = nums.length;
        int prev = nums[0];
        int prev2 = 0;

        for (int i = 1; i < n; i++) {
            int pick = nums[i];
            if (i > 1)
                pick += prev2;
            int nonPick = 0 + prev;

            int cur_i = Math.max(pick, nonPick);
            prev2 = prev;
            prev = cur_i;
        }
        return prev;
    }


    static int houseRobberCircular(int[] nums) {
        int n = nums.length;
//        int[] nums1 = new int[n - 1];
//        int[] nums2 = new int[n - 1];
//
        if (n == 1) {
            return nums[0];
        }
//        nums1[0] = nums[0];
//        nums2[n - 2] = nums[n - 1];
//        for (int i = 1; i < n; ++i) {
//            if (i < n - 1) {
//                nums1[i] = nums[i];
//            }
//            nums2[i-1] = nums[i];
//        }
//        for(int i :nums1) System.out.print(i+" ");
//        System.out.println();
//        for(int i :nums2) System.out.print(i+" ");
//        System.out.println();
        List<Integer> list1 = new ArrayList<>(), list2 = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            if (i != n - 1) list1.add(nums[i]);
            if (i != 0) list2.add(nums[i]);
        }

        int[] nums1 = list1.stream().mapToInt(Integer::intValue).toArray();
        int[] nums2 = list2.stream().mapToInt(Integer::intValue).toArray();


        return Math.max(robDp2(nums1), robDp2(nums2));
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1};

//        arr = new int[]{2, 7, 9, 3, 1};
        arr = new int[]{2, 1, 4, 9};
        System.out.println(robDp(arr));
        System.out.println(houseRobberCircular(arr));
    }
}
