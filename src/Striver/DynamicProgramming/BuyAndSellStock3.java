package Striver.DynamicProgramming;

import java.util.Arrays;

public class BuyAndSellStock3 {
    public static int maxProfit(int ind, int buy, int k, int[] prices, int[][][] dp) {
        if (ind == prices.length || k == 0) return 0;
        if (dp[ind][buy][k] != -1) return dp[ind][buy][k];

        int notTaken = maxProfit(ind+1, buy, k, prices, dp);
        int taken = 0;
        if (k > 0) {
            if (buy == 0) {
                taken =-prices[ind] + maxProfit(ind + 1, 1, k, prices, dp);
            }
            if (buy == 1) {
                taken = prices[ind] + maxProfit(ind + 1, 0, k - 1, prices, dp);
            }
        }
//        System.out.println("notTaken " + notTaken);
//        System.out.println("Taken " + taken);
        return dp[ind][buy][k] = Math.max(taken, notTaken);

    }

    public static int maxProfit(int[] prices, int k) {
        int n = prices.length;
        int[][][] dp = new int[n][2][k + 1];
        for(int[][] i:dp){
            for(int[] j : i){
                Arrays.fill(j,-1);
            }
        }
        int val = maxProfit(0, 0, k, prices, dp);
        return val;
    }

    public static void main(String[] args) {
        int[] arr = {3, 3, 5, 0, 0, 3, 1, 4};
        int k = 2;
        System.out.println(maxProfit(arr, k));
    }
}