package InterviewQuestions;

import java.util.*;

public class Question1 {
//        public static int minSubstrings(String A, String B) {
//            int N = A.length();
//            int M = B.length();
//
//            // Initialize the dp array with a large number
//            int[][] dp = new int[N + 1][M + 1];
//            for (int i = 0; i <= N; i++) {
//                for (int j = 0; j <= M; j++) {
//                    dp[i][j] = Integer.MAX_VALUE;
//                }
//            }
//
//            // Base case: an empty B can be formed with 0 substrings of A
//            for (int i = 0; i <= N; i++) {
//                dp[i][0] = 0;
//            }
//
//            for (int i = 1; i <= N; i++) {
//                for (int j = 1; j <= M; j++) {
//                    if (A.charAt(i - 1) == B.charAt(j - 1)) {
//                        for (int k = 0; k < i; k++) {
//                            if (dp[k][j - 1] != Integer.MAX_VALUE) {
//                                dp[i][j] = Math.min(dp[i][j], dp[k][j - 1] + 1);
//                            }
//                        }
//                    } else {
//                        dp[i][j] = dp[i - 1][j];
//                    }
//                }
//            }
//
//            return dp[N][M] == Integer.MAX_VALUE ? -1 : dp[N][M];
//        }

//    public static int minSubstrings(String A, String B) {
//        int N = A.length();
//        int M = B.length();
//
//        int i = 0;  // Pointer for B
//        int j = 0;  // Pointer for A
//        int substrCount = 1;
//
//        while (i < M) {
//            if (j < N && A.charAt(j) == B.charAt(i)) {
//                // Match found, move to the next character in B and A
//                i++;
//                j++;
//            } else {
//                // No match found, reset pointer in A and increment substring count
//                if (j == N) {
//                    j = 0;
//                    substrCount++;
//                } else {
//                    j++;
//                }
//            }
//
//            // If pointer for A reaches the end without matching the current character in B
//            if (j == N && A.charAt(j - 1) != B.charAt(i - 1)) {
//                return -1; // B cannot be formed from A
//            }
//        }
//
//        return substrCount;
//    }

    public static int minSubstrings(String A, String B) {
        int N = A.length();
        int M = B.length();

        // Create a set of all substrings of A
        Set<String> substrings = new HashSet<>();
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j <= N; j++) {
                substrings.add(A.substring(i, j));
            }
        }

        // DP array to store minimum substrings required for each prefix of B
        int[] dp = new int[M + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        // Fill the DP array
        for (int i = 1; i <= M; i++) {
            for (int j = i; j > 0; j--) {
                String substr = B.substring(j - 1, i);
                if (substrings.contains(substr) && dp[j - 1] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                }
            }
        }

        return dp[M] == Integer.MAX_VALUE ? -1 : dp[M];
    }

    public static int countStr(String a, String b) {
        int n = a.length();
        int m = b.length();

        // Create a set of all substrings of A
        Set<String> substrings = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                substrings.add(a.substring(i, j));
            }
        }

        // DP array to store minimum substrings required for each prefix of B
        int[] dp = new int[m + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        // Fill the DP array
        for (int i = 1; i <= m; i++) {
            for (int j = i; j > 0; j--) {
                String substr = b.substring(j - 1, i);
                if (substrings.contains(substr) && dp[j - 1] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                }
            }
        }

        return dp[m] == Integer.MAX_VALUE ? -1 : dp[m];
    }

//    public static int getBasketsWith(int[] a, int n, int b, int m) {
//        long[] dp = new long[b + 1];
//        dp[0] = 1;
//
//        for (int i = 0; i < n; i++) {
//            for (int j = b; j >= a[i]; j--) {
//                dp[j] = (dp[j] + dp[j - a[i]]) % 1000000007;
//            }
//        }
//
//        long total = dp[b];
//
//        // Remove combinations that don't include the mth item
//        for (int j = 0; j <= b - a[m - 1]; j++) {
//            total = (total - (dp[j] * dp[b - j - a[m - 1]]) % 1000000007 + 1000000007) % 1000000007;
//        }
//
//        return (int) total;
//    }

    public static int getBasketsWith(int[] a, int n, int b, int m) {
        long[] dp = new long[b + 1];
        long[] dpWithM = new long[b + 1];
        dp[0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = b; j >= a[i]; j--) {
                dp[j] = (dp[j] + dp[j - a[i]]) % 1000000007;
                if (i == m - 1) {
                    dpWithM[j] = (dpWithM[j] + dp[j - a[i]]) % 1000000007;
                } else {
                    dpWithM[j] = (dpWithM[j] + dpWithM[j - a[i]]) % 1000000007;
                }
            }
        }

        return (int) dpWithM[b];
    }

    public static int fn(int[] a, int b, int i, int m, int n, int isM ,int[][][] dp) {
        if (b == 0) {
            return isM;
        }
        if(b < 0) return 0;
        if (i == n) {
            if (b == 0) {
                return isM;
            }
            return 0;
        }
        if(dp[b][i][isM] !=-1) return dp[b][i][isM];


        int ans = 0;
        if (i == m - 1) {
            ans += fn(a, b, i + 1, m, n, isM,dp);
            ans += fn(a, b - a[i], i, m, n, 1,dp);
        } else {
            ans += fn(a, b, i + 1, m, n, isM,dp);
            ans += fn(a, b - a[i], i, m, n, isM,dp);
        }
        return dp[b][i][isM] = ans;
    }

    public static void main(String[] args) {
//            String A = "abcabc";
//            String B = "aabbcc";
//
//
//            A="cab";
//
//            B= "abcabc";
//            System.out.println("Minimum number of substrings: " +  minSubstrings(A, B));
//
//            A="cab";
//
//            B="abccab";
//            System.out.println("Minimum number of substrings: " +  minSubstrings(A, B));
//
//            Input: A="abcd";
//
//            B="efghi";
//            System.out.println("Minimum number of substrings: " +  minSubstrings(A, B));
        int[] a = new int[]{1, 2, 3};
        int n = 3, b = 6, m = 3;
//        System.out.println(getBasketsWith(a, n, b, m));
        List<Integer> cur = new ArrayList<>();
        int[][][] dp = new int[b+1][n+1][2];
        for(int i = 0; i <=b;++i){
            for(int j = 0 ; j <= n ; ++j){
                Arrays.fill(dp[i][j],-1);
            }
        }
        System.out.println(fn(a, b, 0, m, n, 0,dp));

        a = new int[]{10, 12, 16, 4, 8};
        n = 5;
        b = 26;
        m = 2;
        dp = new int[b+1][n+1][2];
        for(int i = 0; i <=b;++i){
            for(int j = 0 ; j <= n ; ++j){
                Arrays.fill(dp[i][j],-1);
            }
        }
//        System.out.println(getBasketsWith(a, n, b, m));
        System.out.println(fn(a, b, 0, m, n, 0,dp));
    }
}
