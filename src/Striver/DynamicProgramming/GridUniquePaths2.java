package Striver.DynamicProgramming;

import Striver.Arrays.ArrayImpl;

public class GridUniquePaths2 {
    private static int countWays(int rows, int cols, int[][] grid) {
        int[][] dp = new int[rows][cols];
        dp[0][0] = grid[0][0] == 1 ? 0 : 1;
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if ((i == 0 && j == 0) || grid[i][j] == 1) continue;
                dp[i][j] = (i > 0 && grid[i - 1][j] == 0 ? dp[i - 1][j] : 0) + (j > 0 && grid[i][j - 1] == 0 ? dp[i][j - 1] : 0);
            }
        }
        ArrayImpl.print2dArr(dp);
        return dp[rows - 1][cols - 1];
    }

    public static void main(String[] args) {
        int rows = 3;
        int cols = 3;
        int[][] grid = {
                {0, 0, 0}, {0, 1, 0}, {0, 0, 0}
        };
        System.out.println(countWays(rows, cols, grid));
    }
}
