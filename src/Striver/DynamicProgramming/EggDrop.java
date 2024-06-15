package Striver.DynamicProgramming;

import java.util.Arrays;

public class EggDrop {
    public static int find(int k, int n, int[][] dp) {
        if (n == 0 || n == 1 || k == 1) return n;
        int ans = Integer.MAX_VALUE;
        if (dp[k][n] != -1) return dp[k][n];
        for (int i = 1; i <= n; ++i) {
            // worst case scenario (max value)
            // either the egg breaks then we have k - 1 eggs and i - 1 floors to check
            // or the egg doesn't break then we have k eggs and n - i floors to check
            int temp = 1 + Math.max(find(k - 1, i - 1, dp), find(k, n - i, dp));
            ans = Math.min(ans, temp);
        }
        return dp[k][n] = ans;
    }

    public static int findBS(int k, int n, int[][] dp) {
        if (n == 0 || n == 1 || k == 1) return n;
        int ans = Integer.MAX_VALUE;
        if (dp[k][n] != -1) return dp[k][n];
        int left, right, low = 1, high = n, temp = 0, mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            left = findBS(k - 1, mid - 1, dp);
            right = findBS(k, n - mid, dp);
            temp = 1 + Math.max(left, right);
            if (left < right) {  //since right is more than left and we need more in worst case
                low = mid + 1 ;// so low = mid + 1 to gain more temp for worst case
            } else {
                high = mid - 1;
            }
            ans = Math.min(ans, temp);

        }
        return dp[k][n] = ans;
    }

    public static int superEggDrop(int k, int n) {
        int[][] dp = new int[k + 1][n + 1];
        for (int[] i : dp) Arrays.fill(i, -1);
        return findBS(k, n, dp);
    }

    public static void main(String[] args) {
        int k = 1, n = 2;
        System.out.println(superEggDrop(k, n));
    }
}
