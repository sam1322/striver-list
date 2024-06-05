package Striver.DynamicProgramming;

import Striver.Arrays.ArrayImpl;

public class Knapsack {
    public static int knapSack(int[] wt, int[] val, int W, int n) {
        int[][] dp = new int[n][W + 1];

        for (int w = wt[0]; w <= W; ++w) {
            dp[0][w] = val[0];
        }

        for (int ind = 1; ind < n; ind++) {
            for (int w = 0; w <= W; w++) {
                int notTaken = dp[ind - 1][w];
                int taken = Integer.MIN_VALUE;
                if (wt[ind] <= w) {
                    taken = val[ind] + dp[ind - 1][w - wt[ind]];
                }
                dp[ind][w] = Math.max(taken, notTaken);
            }
        }
        ArrayImpl.print2dArr(dp);
        return dp[n - 1][W];
    }

    public static void main(String[] args) {
        int[] val = {1, 2, 3};
        int[] wt = {4, 5, 1};
        int W = 4;
        System.out.println(knapSack(wt, val, W, wt.length));
    }
}
