package Striver.DynamicProgramming;

import Striver.Arrays.ArrayImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinimumCostToCutTheStick {
    public static int minCost(int i, int j, List<Integer> cuts, int[][] dp) {
        if (i > j) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        int min = Integer.MAX_VALUE;
        for (int ind = i; ind <= j; ++ind) {
            int cost = cuts.get(j + 1) - cuts.get(i - 1) + minCost(i, ind - 1, cuts, dp) + minCost(ind + 1, j, cuts, dp);
            min = Math.min(min, cost);
        }
        return dp[i][j] = min;
    }

    public static int minCost(int n, List<Integer> cuts1) {
        List<Integer> cuts =new ArrayList<>(cuts1);

        cuts.add(n);
        cuts.add(0);
        Collections.sort(cuts);
        int m = cuts.size();
        int[][] dp = new int[m + 1][m + 1];
        for (int[] i : dp) Arrays.fill(i, -1);
        return minCost(1, cuts.size() - 2, cuts, dp);
    }

    public static int minCostDP(int n, List<Integer> cuts1) {
        List<Integer> cuts =new ArrayList<>(cuts1);
        cuts.add(n);
        cuts.add(0);
        Collections.sort(cuts);
        int m = cuts.size();

        int[][] dp = new int[m][m];
//        for (int[] i : dp) Arrays.fill(i, -1);

        int c = m - 2;
        for (int i = c; i > 0; --i) {
            for (int j = 1; j <= c; ++j) {
                if (i > j) continue;
                int min = Integer.MAX_VALUE;
                for (int ind = i; ind <= j; ++ind) {
                    int cost = cuts.get(j + 1) - cuts.get(i - 1) + dp[i][ind - 1] + dp[ind + 1][j];
                    min = Math.min(min, cost);
                }
                dp[i][j] = min;
            }
        }
        ArrayImpl.print2dArr(dp);
        return dp[1][c];
    }




    public static void main(String[] args) {
        ArrayList<Integer> cuts = new ArrayList<>(Arrays.asList(3, 5, 1, 4));
        int c = cuts.size();
        int n = 7;

        System.out.println("The minimum cost incurred: " + minCost(n, cuts));
        System.out.println("The minimum cost incurred: " + minCostDP(n, cuts));
//        System.out.println("The minimum cost incurred: " + cost(n, c, cuts));
    }
}
