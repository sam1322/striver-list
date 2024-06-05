package Striver.DynamicProgramming;

import java.util.Arrays;

public class SubsetSum {
    private static boolean subsetSumToK(int index, int target, int[] arr, int[][] dp) {
        if (target == 0) {
            return true;
        }
        if (index == 0) return arr[0] == target;

        if (dp[index][target] != -1) return dp[index][target] != 0;
        boolean notTaken = subsetSumToK(index - 1, target, arr, dp);
        boolean taken = false;
        if (arr[index] <= target) {
            taken = subsetSumToK(index - 1, target - arr[index], arr, dp);
        }
        dp[index][target] = notTaken || taken ? 1 : 0;
        return notTaken || taken;
    }

    public static void main(String[] args) {
//        int arr[] = {1, 2, 3, 4};
        int arr[] = {1, 11, 1, 4, 4};
        int k = 30;
        int n = arr.length;
        int[][] dp = new int[n][k + 1];
        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }
        // Check if there exists a subset with the given target sum
        if (subsetSumToK(n - 1, k, arr, dp))
            System.out.println("Subset with the given target found");
        else
            System.out.println("Subset with the given target not found");
    }
}
