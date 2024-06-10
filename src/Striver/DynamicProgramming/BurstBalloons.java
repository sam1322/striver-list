package Striver.DynamicProgramming;

import Striver.Arrays.ArrayImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BurstBalloons {
    public static int f(int i, int j, List<Integer> list, int[][] dp) {
        if (i > j) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        int cost, maxi = Integer.MIN_VALUE;
        for (int ind = i; ind <= j; ind++) {
            cost = list.get(i - 1) * list.get(ind) * list.get(j + 1) + f(i, ind - 1, list, dp) + f(ind + 1, j, list, dp);
            maxi = Math.max(maxi, cost);
        }
        return dp[i][j] = maxi;
    }

    public static int maxCoins(int[] nums) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for (int i : nums) list.add(i);
        list.add(1);
        int n = nums.length;
        int[][] dp = new int[n + 1][n + 1];
        for (int[] i : dp) Arrays.fill(i, -1);
        int val = f(1, n, list, dp);
//        ArrayImpl.print2dArr(dp);
        return val;
    }

    public static int maxCoinsDP(int[] nums) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for (int i : nums) list.add(i);
        list.add(1);
        int n = nums.length;
        int[][] dp = new int[n + 2][n + 2];
//        for (int[] i : dp) Arrays.fill(i, -1);
//        int val =  f(1, n, list, dp);
//        ArrayImpl.print2dArr(dp);
//        return val;

        for (int i = n; i > 0; --i) {
            for (int j = 1; j <= n; ++j) {
                if (i > j) continue;
                int cost, maxi = Integer.MIN_VALUE;
                for (int ind = i; ind <= j; ind++) {
                    cost = list.get(i - 1) * list.get(ind) * list.get(j + 1)  + dp[i][ind-1] + dp[ind+1][j];;
                    maxi = Math.max(maxi, cost);
                }
                dp[i][j] = maxi;
            }
        }
        return dp[1][n];
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 5, 8};
        System.out.println(maxCoins(arr));
        System.out.println(maxCoinsDP(arr));
    }
}
