package Striver.DynamicProgramming;

import java.util.Arrays;

public class BuyAndSellStockWithCooldown {

    public static int maxProfit(int ind, int buy,  int[] prices, int[][] dp) {
        if (ind >= prices.length) return 0;
        if (dp[ind][buy] != -1) return dp[ind][buy] ;

        int notTaken = maxProfit(ind + 1, buy,  prices, dp);
        int taken = 0;

            if (buy == 0) {
                taken = -prices[ind] + maxProfit(ind + 1, 1,  prices, dp);
            }
            if (buy == 1) {
                // cooldown of 1 day
                taken = prices[ind] + maxProfit(ind + 1 + 1 , 0,  prices, dp);
            }

//        System.out.println("notTaken " + notTaken);
//        System.out.println("Taken " + taken);
        return dp[ind][buy]  = Math.max(taken, notTaken);

    }

    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2] ;
        for (int[] i : dp) {
                Arrays.fill(i, -1);
        }
        int val = maxProfit(0, 0, prices, dp);
        return val;
    }

    public static void main(String[] args) {
        int[] arr = {4,9,0,4,10};
//        int k = 2;
        System.out.println(maxProfit(arr));
//        System.out.println(maxProfitDP(arr, k));
    }
}
