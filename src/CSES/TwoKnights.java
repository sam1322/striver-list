package CSES;

import java.util.Scanner;

public class TwoKnights {
    static boolean[][] vis;
    static Long[] dp;

    public static Long nC2(Long n) {
        return (n * (n - 1)) / 2;
    }

    public static boolean check(int x, int y, int n, boolean[][] vis) {
        return x >= 0 && x < n && y >= 0 && y < n && !vis[x][y];
    }

//    public static boolean check(int x, int y, int n) {
//        return x >= 0 && x < n && y >= 0 && y < n && !vis[x][y];
//    }

    public static Long attackMoves(int n) {
        boolean[][] vis = new boolean[n][n];

        int[][] loc = {{1, 2}, {1, -2}, {-1, 2}, {-1, -2}};
        Long c = 0L;

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                for (int m = 0; m < 4; ++m) {
                    int x = i + loc[m][0];
                    int y = j + loc[m][1];
                    if (check(x, y, n, vis)) {
                        c++;

                    }
                }
                for (int m = 0; m < 4; ++m) {
                    int x = i + loc[m][1];
                    int y = j + loc[m][0];
                    if (check(x, y, n, vis)) {
                        c++;

                    }
                }
                vis[i][j] = true;
            }
        }

        return c;

    }

    public static Long attackMovesDP(int n, boolean[][] vis) {
        if (n == 1 || n == 2) return 0L;
        int[][] loc = {{1, 2}, {1, -2}, {-1, 2}, {-1, -2}};
        Long c = 0L;

        for (int i = 0; i < n; ++i) {
            for (int m = 0; m < 4; ++m) {
                int x = i + loc[m][0];
                int y = n - 1 + loc[m][1];
                if (check(x, y, n, vis)) {
                    c++;
                }
            }
            for (int m = 0; m < 4; ++m) {
                int x = i + loc[m][1];
                int y = n - 1 + loc[m][0];
                if (check(x, y, n, vis)) {
                    c++;
                }
            }
            vis[i][n - 1] = true;

        }
        for (int i = 0; i < n - 1; ++i) {
            for (int m = 0; m < 4; ++m) {
                int x = n - 1 + loc[m][0];
                int y = i + loc[m][1];
                if (check(x, y, n, vis)) {
                    c++;
                }
            }
            for (int m = 0; m < 4; ++m) {
                int x = n - 1 + loc[m][1];
                int y = i + loc[m][0];
                if (check(x, y, n, vis)) {
                    c++;
                }
            }
            vis[n - 1][i] = true;

        }
        return c;
//        return dp[n - 1] + c;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = scanner.nextInt();
        boolean[][] vis = new boolean[n][n];
        dp = new Long[n + 1];

        for (int i = 1; i <= n; ++i) {
            Long nc2 = nC2((long) (i * i));
            Long attack = 4L * (i-1)*(i-2);
//            System.out.println(i+"C2 : " + nc2);
//            Long attackMove = attackMovesDP(i);
//            Long attackMove = attackMovesDP(i, vis);
//            if (i > 1)
//                dp[i] = dp[i - 1] + attackMove;
//            System.out.println("attackMoves : " + attackMove);
//            Long ans = nc2 - attackMove;
////            System.out.println(ans);
            Long ans = nc2 - attack;
            sb.append(ans + "\n");
        }
        System.out.println(sb);

    }
}
