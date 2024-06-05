package Striver.DynamicProgramming;

import Striver.Arrays.ArrayImpl;

import java.util.Arrays;

public class BuyAndSellStock2 {

    public static int maxProfit(int index, int buy, int[] prices, int[][] dp) {
        if (index == prices.length) {
            return 0;
        }
        if (dp[index][buy] != -1) return dp[index][buy];
        int notTaken = maxProfit(index + 1, buy, prices, dp);
        int taken = maxProfit(index + 1, (buy + 1) % 2, prices, dp) + (buy == 0 ? -prices[index] : prices[index]);
        return dp[index][buy] = Math.max(notTaken, taken);
    }

    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int[] i : dp) Arrays.fill(i, -1);
        int val = maxProfit(0, 0, prices, dp);
//        ArrayImpl.print2dArr(dp);
        return val;
    }

    public static int maxProfitDp(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];
        dp[0][0] = dp[0][1] = 0;
        for (int index = n - 1; index >= 0; --index) {
            for (int buy = 0; buy < 2; ++buy) {
                int profit = 0;
                if (buy == 0) {
                    profit = Math.max(0 + dp[index + 1][0], -prices[index] + dp[index + 1][1]);
                }
                if (buy == 1) {
                    profit = Math.max(0 + dp[index + 1][1], prices[index] + dp[index + 1][0]);
                }
                dp[index][buy]  = profit;
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
//        int[] arr = {7, 1, 5, 3, 6, 4};
        int[] arr = {7, 6, 4, 3, 1};
        System.out.println(maxProfit(arr));
        System.out.println(maxProfitDp(arr));
    }
}
