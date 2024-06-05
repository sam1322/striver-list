package Striver.DynamicProgramming;

import Striver.Arrays.ArrayImpl;

import java.util.Arrays;

public class LongestCommonSubsequence {
    public static String printLcs(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        String[][] dp = new String[n + 1][m + 1];
        for (String[] i : dp) {
            Arrays.fill(i, "");
        }

        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= m; j++) {
                String mx = "";
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    mx = dp[i - 1][j] + s1.charAt(i - 1);
                } else {
                    String mx1 = dp[i - 1][j];
                    String mx2 = dp[i][j - 1];
                    if (mx1.length() > mx2.length()) {
                        mx = mx1;
                    } else {
                        mx = mx2;
                    }
                }
                dp[i][j] = mx;
            }
        }
        System.out.println(s1);
        System.out.println(s2);
//        ArrayImpl.print2dArr(dp);
        return dp[n][m];

    }

    public static int lcs(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        // Create a 2D array to store the LCS lengths
        int dp[][] = new int[n + 1][m + 1];

//        // Initialize the dp array with -1
//        for (int rows[] : dp)
//            Arrays.fill(rows, -1);
//
//        // Initialize the first row and first column with 0
//        for (int i = 0; i <= n; i++) {
//            dp[i][0] = 0;
//        }
//        for (int i = 0; i <= m; i++) {
//            dp[0][i] = 0;
//        }

        // Fill the dp array using a bottom-up approach
        for (int ind1 = 1; ind1 <= n; ind1++) {
            for (int ind2 = 1; ind2 <= m; ind2++) {
                if (s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1))
                    dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1];
                else
                    dp[ind1][ind2] = Math.max(dp[ind1 - 1][ind2], dp[ind1][ind2 - 1]);
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "bdgek";
        System.out.println(printLcs(s1, s2));
        System.out.println(lcs(s1, s2));
    }
}
