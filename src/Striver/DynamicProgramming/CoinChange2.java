package Striver.DynamicProgramming;

import Striver.Arrays.ArrayImpl;

public class CoinChange2 {
    public static int change(int target, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][target + 1];
        for (int i = 0; i <= target; ++i) {
            if (i % coins[0] == 0) {
                dp[0][i] = 1;
            }
        }
        for(int ind = 1 ; ind < n ; ++ind){
            for(int t = 0 ; t <= target ; ++t){
                int notTaken  = dp[ind - 1][t];
                int taken = 0 ;
                if( coins[ind] <= t){
                    taken = dp[ind][t - coins[ind]];
                }
                dp[ind][t] = notTaken + taken;
            }
        }
        ArrayImpl.print2dArr(dp);
        return dp[n-1][target];
    }

    public  static long countWaysToMakeChange(int T,int[] arr) {
        int n = arr.length;
        // Create a 2D array to store results of subproblems
        long dp[][] = new long[n][T + 1];

        // Initialize base condition for the first element of the array
        for (int i = 0; i <= T; i++) {
            if (i % arr[0] == 0)
                dp[0][i] = 1;
            // Else condition is automatically fulfilled, as dp array is initialized to zero
        }

        // Fill the dp array using dynamic programming
        for (int ind = 1; ind < n; ind++) {
            for (int target = 0; target <= T; target++) {
                long notTaken = dp[ind - 1][target];

                long taken = 0;
                if (arr[ind] <= target)
                    taken = dp[ind][target - arr[ind]];

                dp[ind][target] = notTaken + taken;
            }
        }
        ArrayImpl.print2dArrlong(dp);
        return dp[n - 1][T];
    }

    public static void main(String[] args) {
        int []arr = {1,2,5};
        int target = 5;
        System.out.println(change(target,arr));
        System.out.println(countWaysToMakeChange(target,  arr));
    }
}
