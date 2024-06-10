package Striver.DynamicProgramming;

import java.util.Arrays;

public class MatrixMultiplication {
    public static int f(int i, int j, int[] arr, int[][] dp) {
        if (i == j) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        int mini = Integer.MAX_VALUE;
        for (int k = i; k < j; ++k) {
            int steps = (arr[i - 1] * arr[k] * arr[j]) + f(i, k, arr, dp) + f(k + 1, j, arr, dp);
            if (mini > steps) mini = steps;
        }
        return dp[i][j] = mini;
    }

    public static int matrixMultiplication(int[] arr, int N) {
        // Write your code here
        int[][] dp = new int[N][N];
        for(int[] i : dp) Arrays.fill(i,-1);
        return f(1, N - 1, arr, dp);
    }

    public static void main(String[] args) {
//        int[] arr= {10,20,30,40,50};
//        int[] arr= {4,5,3,2};
        int[] arr = {10, 15, 20, 25};
        System.out.println(matrixMultiplication(arr, arr.length));
    }
}
