package Striver.DynamicProgramming;

import java.util.Arrays;

public class PalindromePartitioning2 {
    public static boolean checkPalindrome(int i, int j, String s) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    public static int minCut1(int i, int j, String s, Integer[][] dp) {
//        if (i > j) return -1;
//        if (i == j || checkPalindrome(i, j, s)) {
        if (i == j) {
            return dp[i][j] = 0;
        }
        if (dp[i][j] != null) return dp[i][j];
        int mini = Integer.MAX_VALUE;
        for (int ind = i; ind < j; ++ind) {
//            int left = minCut(i, ind, s, dp);
//            int right = minCut(ind + 1, j, s, dp);
////            if (left == -1 || right == -1) continue;
//            int cost = left + right + 1;
//            mini = Math.min(mini, cost);

            if (checkPalindrome(i, ind, s)) {
                int cost = 1 + minCut1(ind + 1, j, s, dp);
                mini = Math.min(mini, cost);
            }
        }
//        if (mini == Integer.MAX_VALUE) mini = -1;
        return dp[i][j] = mini;
    }

    public static int minCut(int i, int n, String s, Integer[] dp) {
        if (i == n) {
            return 0;
        }
        if (dp[i] != null) return dp[i];
        int mini = Integer.MAX_VALUE;
        for (int ind = i; ind < n; ++ind) {
            if (checkPalindrome(i, ind, s)) {
                int cost = 1 + minCut(ind + 1, n, s, dp);
                mini = Math.min(mini, cost);
            }
        }
//        if (mini == Integer.MAX_VALUE) mini = -1;
        return dp[i] = mini;
    }

    public static int minCut(String s) {
        int n = s.length();
        Integer[] dp = new Integer[n];
//        for (int[] i : dp) Arrays.fill(i, -1);
        return minCut(0, n, s, dp) - 1;
    }

    public static void main(String[] args) {
        String s = "bababcbadcede";
//        String s = "baba";
        System.out.println(minCut(s));
    }
}
