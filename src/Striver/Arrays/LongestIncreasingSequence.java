package Striver.Arrays;

import java.util.Arrays;

public class LongestIncreasingSequence {
    public static int lis(int index, int prev, int[] nums, int[][] dp) {
        if (index == nums.length) return 0;
        if (dp[index][prev + 1] != -1) return dp[index][prev + 1];
        int notTaken = 0 + lis(index + 1, prev, nums, dp);
        int taken = 0;
        if (prev == -1 || (nums[prev] < nums[index] && index != prev)) {
            taken = 1 + lis(index + 1, index, nums, dp);
        }
        return dp[index][prev + 1] = Math.max(notTaken, taken);

    }

    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n + 1];
        for (int[] i : dp) Arrays.fill(i, -1);
        int val = lis(0, -1, nums, dp);
        ArrayImpl.print2dArr(dp);
        return val;
    }
    public static int lengthOfLIS_DP(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n + 1];
        for (int[] i : dp) Arrays.fill(i, -1);
        int val = lis(0, -1, nums, dp);
        ArrayImpl.print2dArr(dp);
        return val;
    }

    public static void main(String[] args) {
        int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(arr));
    }
}
