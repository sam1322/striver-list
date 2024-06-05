package Striver.DynamicProgramming;

public class RodCutting {
    public static int rodCutting(int length, int[] rod) {
        int n = rod.length;
        int[][] dp = new int[n][length + 1];

        for (int l = 0; l <= length; ++l) dp[0][l] = l * rod[0];

        for (int index = 1; index < n; index++) {
            for (int len = 0; len <= length; len++) {
                int notTaken = dp[index - 1][len];
                int taken = 0;
                if (index < len) {
                    taken = rod[index] + dp[index][len - (index + 1)];
                }
                dp[index][len] = Math.max(taken,notTaken)
;            }
        }
        return dp[n - 1][length];
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 7, 8, 10};
        int length = 5;
        System.out.println(rodCutting(length, arr));
    }
}
