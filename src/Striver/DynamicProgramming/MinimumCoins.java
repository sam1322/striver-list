package Striver.DynamicProgramming;

import Striver.Arrays.ArrayImpl;

import java.util.Arrays;

public class MinimumCoins {
    public static int minimumCoins(int ind, int T, int[] coins, int[][] dp) {
        if (ind == 0) {
//            int val = Integer.MAX_VALUE;
            int val = (int) Math.pow(10, 9);
            if (T % coins[0] == 0) {
                val = T / coins[0];
            }
//            dp[ind][T] = val;
            return val;
        }
        if (dp[ind][T] != -1) return dp[ind][T];
//        pick / not pick soln
        int notTaken = 0 + minimumCoins(ind - 1, T, coins, dp);
        int taken = (int) Math.pow(10, 9);
        if (coins[ind] <= T) {
            taken = 1 + minimumCoins(ind, T - coins[ind], coins, dp);
        }
        return dp[ind][T] = Math.min(taken, notTaken);
    }

    public static void main(String[] args) {
//        int[] coins = {1, 2, 5};
//        int t = 11;

        int[] coins = {2, 5, 10, 1};
        int t = 27;
        int n = coins.length;
        int[][] dp = new int[n][t + 1];
        for (int[] i : dp) Arrays.fill(i, -1);
        int ans = minimumCoins(n - 1, t, coins, dp);
        if (ans >= (int) Math.pow(10, 9)) ans = -1;
        ArrayImpl.print2dArr(dp);
        System.out.println(ans);
    }
}
