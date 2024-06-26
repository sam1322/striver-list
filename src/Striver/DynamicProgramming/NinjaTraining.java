package Striver.DynamicProgramming;

import java.util.Arrays;

public class NinjaTraining {
    static int[][] dp;

    public static int f(int n, int i, int[][] act) {
        if (n == 0) return dp[n][i] = act[n][i];
        if (dp[n][i] != -1) return dp[n][i];
        return dp[n][i] = Math.max(f(n - 1, (i + 1) % 3, act), f(n - 1, (i + 2) % 3, act)) + act[n][i];
    }

    public static int ninjaTraining(int[][] activities, int n) {
        dp = new int[n][3];
//        Arrays.fill(dp,-1);
        for (int i = 0; i < n; ++i) {
            Arrays.fill(dp[i], -1);
        }

//        for (int i = 0; i < n; ++i) {
//            for (int j = 0; j < 3; ++j) System.out.print(dp[i][j] + " ");
//            System.out.println();
//        }

        int val = Math.max(f(n - 1, 0, activities), Math.max(f(n - 1, 1, activities), f(n - 1, 2, activities)));
//        for (int i = 0; i < n; ++i) {
//            for (int j = 0; j < 3; ++j) System.out.print(dp[i][j] + " ");
//            System.out.println();
//        }
        return val;
    }

    static int func(int n, int last, int[][] act) {
        int mx = 0;
        if (n < 0) return 0;
        if (dp[n][last] != -1) return dp[n][last];

        for (int i = 0; i < 3; ++i) {
            if (i != last) {
                mx = Math.max(mx, act[n][i] + func(n - 1, i, act));
            }
        }
        return dp[n][last] = mx;
    }

    public static int ninjaTraining_Striver(int[][] activities, int n) {
        dp = new int[n][4];

        for (int i = 0; i < n; ++i) {
            Arrays.fill(dp[i], -1);
        }
        int val = func(n - 1, 3, activities);
        return val;
    }

    public static int ninjaTrainingDp(int[][] act, int n) {
//        int ans = 0;
        int[][] dp = new int[n + 1][4];
        for (int last = 0; last < 4; ++last) {
            int mx = 0;
            for (int i = 0; i < 3; ++i) {
                if (i != last) {
                    mx = Math.max(mx, act[0][i]);
                }
            }
            dp[0][last] = mx;
        }
        for (int day = 1; day < n; ++day) {
            for (int last = 0; last < 4; ++last) {
                int mx = 0;
                for (int i = 0; i < 3; ++i) {
                    if (i != last) {
                        mx = Math.max(mx, act[day][i] + dp[day - 1][i]);
                    }
                }
                dp[day][last] = mx;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 4; ++j)
                System.out.print(dp[i][j] + " ");
            System.out.println();
        }
        return dp[n - 1][3];
    }

    public static void main(String[] args) {
        int[][] act = {
                {10, 40, 70},
                {20, 50, 80},
                {30, 60, 90},
        };
        System.out.println(ninjaTraining(act, act.length));
        System.out.println(ninjaTraining_Striver(act, act.length));
        System.out.println(ninjaTrainingDp(act, act.length));
    }
}
