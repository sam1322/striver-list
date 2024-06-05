package Striver.DynamicProgramming;

import Striver.Arrays.ArrayImpl;

public class UnboundedKnapsack {
    public static int unboundedKnapsack(int[] wt, int[] val, int W) {
        int n = wt.length;
        int[][] dp = new int[n][W + 1];
        for (int w = 0; w <= W; w++) {
            dp[0][w] = (w / wt[0]) * val[0];
        }
        for (int ind = 1; ind < n; ++ind) {
            for (int w = 0; w <= W; ++w) {
                int notTaken = 0 + dp[ind - 1][W];
                int taken = Integer.MIN_VALUE;
                if (wt[ind] <= w) {
                    taken = val[ind] + dp[ind][W - wt[ind]];
                }
                dp[ind][w] = Math.max(notTaken, taken);
            }
        }
        ArrayImpl.print2dArr(dp);
        return dp[n-1][W];
    }

    public static void main(String[] args) {
        int wt[] = {2, 4, 6};
        int val[] = {5, 11, 13};
        int W = 10;
        int n = wt.length;

        // Call the unboundedKnapsack function and print the result
        System.out.println("The Maximum value of items the thief can steal is " + unboundedKnapsack(wt, val, W));

    }
}
