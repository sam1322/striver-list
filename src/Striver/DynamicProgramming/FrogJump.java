package Striver.DynamicProgramming;

import java.util.Arrays;

public class FrogJump {

    private static int[] dp;
    private static int k;

    public static int minimumEnergyHelper(int arr[], int n) {
        //code here
        if (n == 0) return 0;
        if (dp[n] != -1) return dp[n];
        int minVal =Integer.MAX_VALUE;
        for (int i = 1; i <= k; ++i) {
            int rightOne = Integer.MAX_VALUE;
            if (n >= i) {
                rightOne = minimumEnergyHelper(arr, n - i) + diff(arr, n, n - i);
            }
            minVal = Math.min(minVal, rightOne);
        }

        return dp[n] = minVal;

    }

    private static int diff(int arr[], int i, int j) {
        return Math.abs(arr[i] - arr[j]);
    }

    public static int minimumEnergy(int arr[], int n, int K) {
        //code here
        dp = new int[n];
        Arrays.fill(dp, -1);
        k = K;
        return minimumEnergyHelper(arr, n - 1);
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 10};
        int n = arr.length;
        int k = 3;
//        dp = new int[n];
//        Arrays.fill(dp, -1);
        System.out.println(minimumEnergy(arr, n, k));
    }
}
