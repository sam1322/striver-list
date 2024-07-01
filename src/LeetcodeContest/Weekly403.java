package LeetcodeContest;

import Striver.Arrays.ArrayImpl;

import java.util.Arrays;

public class Weekly403 {
    public static double minimumAverage(int[] nums) {
        Arrays.sort(nums);
        double ans = Double.MAX_VALUE;
        int n = nums.length;
        int i = 0, j = n - 1;
        while (i < j) {
            double cur = (nums[i] + nums[j]) / 2.0;
            ans = Math.min(ans, cur);
            i++;
            j--;
        }
        return ans;
    }

    public static int minimumArea(int[][] grid) {
        int n = grid.length, m = grid[0].length;

        int x1 = n - 1, y1 = m - 1;
        int x2 = 0, y2 = 0;
//        boolean flag = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    x1 = Math.min(x1, i);
                    y1 = Math.min(y1, j);

                    x2 = Math.max(x2, i);
                    y2 = Math.max(y2, j);
                }
            }
        }
        int w = x2 - x1 + 1;
        int l = y2 - y1 + 1;
//        System.out.println(x1 + " " + y1);
//        System.out.println(x2 + " " + y2);
        return l * w;
    }

    public static int cost(int[] nums, int l, int r) {
        int sum = 0;
        for (int i = l; i < r; ++i) {
            if ((i - l) % 2 == 0) {
                sum += nums[i];
            } else {
                sum -= nums[i];
            }
        }
        return sum;
    }

    public static long rec(int ind, int prev, int[] nums, Long[][] dp) {
        if (ind == nums.length) return 0;
        if (dp[ind][prev] != null) return dp[ind][prev];
        long ans = 0;
        if (prev == 0) { // that is prev element was added then this time we will subtract
            ans = -nums[ind] + rec(ind + 1, 1, nums, dp);
            ans = Math.max(ans, nums[ind] + rec(ind + 1, 0, nums, dp));
        } else {
            ans = nums[ind] + rec(ind + 1, 0, nums, dp);
        }
        return dp[ind][prev] = ans;
    }

    public static long maximumTotalCost(int[] nums) {
//        int n = nums.length;
//        int ans = 0;
//        int l = -1, r = -1;
//        for (int i = 0; i < n; ++i) {
//            if (l == -1) {
//                l = r = i;
//
//            }
//        }
        int n = nums.length;
        Long[][] dp = new Long[n][2];
        Long val = rec(0, 1, nums, dp);
//        ArrayImpl.print2dArr(dp);
        return val;
    }


    public static int minimumArea(int[][] grid, int start_row, int end_row, int start_col, int end_col) {
        int startRow = Integer.MAX_VALUE, endRow = -1, startCol = Integer.MAX_VALUE, endCol = -1;
        boolean found = false;
        for (int i = start_row; i <= end_row; ++i) {
            for (int j = start_col; j <= end_col; ++j) {
//                System.out.println(i+":"+j);
                if ( grid[i][j] == 1) {
                    startRow = Math.min(i, startRow);
                    endRow = Math.max(i, endRow);
                    startCol = Math.min(j, startCol);
                    endCol = Math.max(j, endCol);
                    found = true;
                }
            }
        }
        if (found) {
            int width = endCol - startCol + 1;
            int height = endRow - startRow + 1;
            return width * height;
        }
//        return 1000000007;
        return 0;
    }


    public static int minimumSum(int[][] grid) {
        int i, j, m = grid.length, n = grid[0].length, one, two, three;
        int ans = Integer.MAX_VALUE;

        /*
        -------------
        |    (1)    |
        |           |
        -------------
        | (2) | (3) |
        |     |     |
        -------------
        */
        for (i = 0; i < m; ++i) {
            one = minimumArea(grid, 0, i, 0, n - 1);
            for (j = 0; j < n; j++) {
                two = minimumArea(grid, i + 1, m - 1, 0, j);
                three = minimumArea(grid, i + 1, m - 1, j + 1, n - 1);
                ans = Math.min(ans, one + two + three);
//                System.out.println(one + " : " + two + " : " + three);
            }
        }

         /*
        -------------
        |     | (2) |
        |     |     |
          (1) -------
        |     |     |
        |     | (3) |
        -------------
        */
        for (j = 0; j < n; j++) {
            one = minimumArea(grid, 0, m - 1, 0, j);
            for (i = 0; i < m; i++) {
                two = minimumArea(grid, 0, i, j + 1, n - 1);
                three = minimumArea(grid, i + 1, m - 1, j + 1, n - 1);
                ans = Math.min(ans, one + two + three);
            }
        }

        /*
        -------------
        |     |     |
        | (2) |     |
        ------- (1) |
        |     |     |
        | (3) |     |
        -------------
        */
        for (j = n - 1; j >= 0; j--) {
            one = minimumArea(grid, 0, m - 1, j + 1, n - 1);
            for (i = 0; i < m; i++) {
                two = minimumArea(grid, 0, i, 0, j);
                three = minimumArea(grid, i + 1, m - 1, 0, j);
                ans = Math.min(ans, one + two + three);
            }
        }


        /*
        -------------
        | (2) | (3) |
        |     |     |
        ------------
        |           |
        |    (1)    |
        -------------
        */
        for (i = m - 1; i >= 0; i--) {
            one = minimumArea(grid, i + 1, m - 1, 0, n - 1);
            for (j = 0; j < n; j++) {
                two = minimumArea(grid, 0, i, 0, j);
                three = minimumArea(grid, 0, i, j + 1, n - 1);
                ans = Math.min(ans, one + two + three);
            }
        }


        /*
        -------------
        |    (1)    |
        -------------
        |    (2)    |
        -------------
        |    (3)    |
        -------------
        */
        for (i = 0; i < m; i++) {
            for (j = i + 1; j < m; j++) {
                one = minimumArea(grid, 0, i, 0, n - 1);
                two = minimumArea(grid, i + 1, j, 0, n - 1);
                three = minimumArea(grid, j + 1, m - 1, 0, n - 1);
                ans = Math.min(ans, one + two + three);
            }
        }

         /*
        -------------
        |   |   |   |
        |   |   |   |
        |(1)|(2)|(3)|
        |   |   |   |
        |   |   |   |
        -------------
        */
        for (i = 0; i < n; i++) {
            for (j = i + 1; j < n; j++) {
                one = minimumArea(grid, 0, m - 1, 0, i);
                two = minimumArea(grid, 0, m - 1, i + 1, j);
                three = minimumArea(grid, 0, m - 1, j + 1, n - 1);
                ans = Math.min(ans, one + two + three);
            }
        }


        return ans;

    }

    public static void main(String[] args) {
        int[] arr1 = {7, 8, 3, 4, 15, 13, 4, 1};
        System.out.println(minimumAverage(arr1));
//        int[][] grid = {{0, 1, 0}, {1, 0, 1}};
        int[][] grid = {{1, 0}, {0, 0}};
        System.out.println(minimumArea(grid));

//        int[] arr3 = {1, -2, 3, 4};
//        int[] arr3 = {1, -1, 1, -1};
        int[] arr3 = {-14, -13, -20};
        System.out.println(maximumTotalCost(arr3));

//        int[][] grid1 = {{1, 0, 1}, {1, 1, 1}};
        int[][] grid1 = {{0, 0, 0}, {0, 0, 0}, {0, 0, 1}, {1, 1, 0}};
        System.out.println(minimumSum(grid1));

    }
}


