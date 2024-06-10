package Striver.DynamicProgramming;

public class EvaluateBooleanExpression {

    static final int MOD = 1000000007;

    private static int[] f(int i, int j, String s) {
        if (i > j) return new int[]{0, 0};
        if (i == j) {
            char ch = s.charAt(i);
            return new int[]{ch == 'T' ? 1 : 0, ch == 'F' ? 1 : 0};
        }
        int countTrue = 0;
        int countFalse = 0;

        for (int ind = i + 1; ind < j; ind++) {
            int[] left = f(i, ind - 1, s);
            int[] right = f(ind + 1, j, s);
            int leftTrue = left[0];
            int leftFalse = left[1];
            int rightTrue = right[0];
            int rightFalse = right[1];

            int x1 = leftTrue * rightTrue;
            int x2 = leftTrue * rightFalse;
            int x3 = leftFalse * rightTrue;
            int x4 = leftFalse * rightFalse;

            char ch = s.charAt(ind);
            if (ch == '&') {
                countTrue += x1;
                countFalse += x2 * x3;
            } else if (ch == '|') {
                countTrue += x1 + x2 + x3;
                countFalse += x4;
            } else {
                countTrue += x2 + x3;
                countFalse += x1 + x4;
            }
        }
        return new int[]{countTrue, countFalse};
    }

    private static Long f(int i, int j, int isTrue, String s, Long[][][] dp) {
        if (i > j) return 0L;

        if (dp[i][j][isTrue] != null) {
            return dp[i][j][isTrue];
        }
        if (i == j) {
            char ch = s.charAt(i);
            long val = isTrue == 1 ? ch == 'T' ? 1L : 0L : ch == 'F' ? 1L : 0L;
//            System.out.println("Hello" + val);
            return val;
        }
        long countTrue = 0L;
        long countFalse = 0L;

        for (int ind = i + 1; ind < j; ind++) {
//            int[] left = f(i, ind - 1, s);
//            int[] right = f(ind + 1, j, s);
            long leftTrue = f(i, ind - 1, 1, s, dp);
            long leftFalse = f(i, ind - 1, 0, s, dp);
            long rightTrue = f(ind + 1, j, 1, s, dp);
            long rightFalse = f(ind + 1, j, 0, s, dp);


            long x1 = (leftTrue * rightTrue) % MOD;
            long x2 = (leftTrue * rightFalse) % MOD;
            long x3 = (leftFalse * rightTrue) % MOD;
            long x4 = (leftFalse * rightFalse) % MOD;

            char ch = s.charAt(ind);
            if (ch == '&') {
                countTrue = (countTrue + x1) % MOD;
                countFalse = (countFalse + x2 + x3) % MOD;
            } else if (ch == '|') {
                countTrue = (countTrue + x1 + x2 + x3) % MOD;
                countFalse = (countFalse + x4) % MOD;
            } else {
                countTrue = (countTrue + x2 + x3) % MOD;
                countFalse = (countFalse + x1 + x4) % MOD;
            }
        }
        return dp[i][j][isTrue] = (isTrue == 1 ? countTrue : countFalse);
    }


    public static Long parseBoolExpr(String expression) {
        int n = expression.length();
        Long[][][] dp = new Long[n][n][2];
        Long ans = f(0, n - 1, 1, expression, dp);
        return ans;
    }

    public static void main(String[] args) {
        String s = "";
        s = "T|T&F";
        s = "F|T^F";
        System.out.println(parseBoolExpr(s));
    }
}
