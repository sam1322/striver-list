package Striver.DynamicProgramming;

import java.util.Arrays;

public class WildCardMatching {

    // Helper function to check if all characters from index 0 to i in S1 are '*'
    static boolean isAllStars(String S1, int i) {
        for (int j = 0; j <= i; j++) {
            if (S1.charAt(j) != '*')
                return false;
        }
        return true;
    }

    public static int wildcardMatchingUtil(String s1, String s2, int i, int j, int[][] dp) {
        if (i < 0 && j < 0) return 1;
        if (i < 0 && j >= 0) return 0;
        if (i >= 0 && j < 0) return isAllStars(s1, i) ? 1 : 0;
        if (dp[i][j] != -1) return dp[i][j];

        int ans = 0;
        if (s1.charAt(i) == s2.charAt(j) || s1.charAt(i) == '?') {
            ans = wildcardMatchingUtil(s1, s2, i - 1, j - 1, dp);
        } else if (s1.charAt(i) == '*') {
            ans = (wildcardMatchingUtil(s1, s2, i - 1, j, dp) == 1 || wildcardMatchingUtil(s1, s2, i, j - 1, dp) == 1) ? 1 : 0;
        }
        return dp[i][j] = ans;
    }

    // Main function to check if S1 matches the wildcard pattern S2
    static int wildcardMatching(String S1, String S2) {
        int n = S1.length();
        int m = S2.length();

        int dp[][] = new int[n][m];
        for (int row[] : dp)
            Arrays.fill(row, -1);

        // Call the recursive helper function
        return wildcardMatchingUtil(S1, S2, n - 1, m - 1, dp);
    }

    public static void main(String[] args) {
        String S1 = "ab*cd";
        String S2 = "abdefcd";

        if (wildcardMatching(S1, S2) == 1)
            System.out.println("String S1 and S2 do match");
        else
            System.out.println("String S1 and S2 do not match");
    }
}
