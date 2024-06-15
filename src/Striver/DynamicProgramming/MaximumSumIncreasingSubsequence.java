package Striver.DynamicProgramming;

import java.util.Arrays;

public class MaximumSumIncreasingSubsequence {
    public static int maxSum(int ind, int prev, int[] arr, int[][] dp) {
        if (ind == arr.length) return 0;
        if (dp[ind][prev + 1] != -1) return dp[ind][prev + 1];
        int notTaken = maxSum(ind + 1, prev, arr,dp);
        int taken = 0;
        if (prev == -1 || arr[prev] < arr[ind]) {
            taken = arr[ind] + maxSum(ind + 1, ind, arr,dp);
        }
        return dp[ind][prev + 1] = Math.max(notTaken, taken);
    }

    public static int maxSum(int[] arr) {
        int n = arr.length;
        int[][] dp= new int[n][n+1];
        for(int[] i: dp) Arrays.fill(i,-1);
        return maxSum(0, -1, arr,dp);
    }

    public static void main(String[] args) {
        int[] arr = {1, 101, 2, 3, 100};
        System.out.println(maxSum(arr));
    }
}
