package Striver.DynamicProgramming;

import java.util.Arrays;

public class PartitionArrayForMaximumSum {
    public static int maxSumAfterPartitioning(int i, int n, int[] arr, int k, int[] dp) {
        if (i == n) return 0;
        if (dp[i] != -1) return dp[i];
        int sum = arr[i];
        int maxSum = Integer.MIN_VALUE;
        for (int ind = i; ind < Math.min(n, i + k); ind++) {
//            sum += arr[ind];
            sum = Math.max(sum, arr[ind]);
            int totalSum = sum * (ind - i + 1);
//            System.out.println(totalSum + " : " + (ind - i + 1));
            maxSum = Math.max(maxSum, totalSum + maxSumAfterPartitioning(ind + 1, n, arr, k, dp));
        }
        return dp[i] = maxSum;
    }

    public static int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        int val = maxSumAfterPartitioning(0, n, arr, k, dp);
        return val;
    }

    public static void main(String[] args) {
        int[] arr = {1, 15, 7, 9, 2, 5, 10};
        int k = 3;
        System.out.println(maxSumAfterPartitioning(arr, k));
    }
}
