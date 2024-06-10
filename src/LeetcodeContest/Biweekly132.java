package LeetcodeContest;

import Striver.Arrays.ArrayImpl;

import java.util.*;

public class Biweekly132 {
    public static String clearDigits(String s) {
        Stack<Character> st = new Stack<>();
        String str = "";
        for (int i = 0; i < s.length(); ++i) {
            Character ch = s.charAt(i);
            if (ch >= '0' && ch <= '9') {
                if (!str.isEmpty()) {
                    str = str.substring(0, str.length() - 1);
                }
            } else {
                str += ch;
            }
        }
        return str;
    }

    public static int findWinningPlayer(int[] skills, int k) {
        List<Integer[]> list = new ArrayList<>();
        int n = skills.length;
        for (int i = 0; i < n; ++i) {
            list.add(new Integer[]{i, skills[i]});
        }
        Collections.sort(list, (a, b) -> {
            if (a[1] == b[1]) return a[0] - b[1];
            return a[1] - b[1];
        });

        int ind, minInd = 0, x;
        if (k < n) {
            ind = list.get(k)[0];
            minInd = list.get(k)[0];
            x = 1;
            List<Integer[]> arr = new ArrayList<>();
            for (int i = k; i < n; ++i) {
//                arr.add(list.get(i));
                Integer[] cur = list.get(i);
                int index = cur[0];
                if (minInd > index) {
                    minInd = index;
                }
            }
            if (minInd == 0 && k != 1) x = 0;

            for (int i = k + 1; i < n; ++i) {
                Integer[] cur = list.get(i);
                int index = cur[0];
                if (Math.abs(minInd - index) + x <= k) {
                    minInd = index;
                    x = 1;
                }
            }
        } else {
            minInd = list.get(list.size() - 1)[0];
        }
        return minInd;

    }

    public static int maximumLength(int ind, int prev, int k, int[][][] dp, int[] nums) {
        if (ind == nums.length) return 0;

        if (dp[ind][prev + 1][k] != -1) return dp[ind][prev + 1][k];

        int notTaken = maximumLength(ind + 1, prev, k, dp, nums);
        int taken = 0;
        if (prev == -1 || (nums[ind] == nums[prev])) {
            taken = 1 + maximumLength(ind + 1, ind, k, dp, nums);
        } else if (k > 0 && nums[ind] != nums[prev]) {
            taken = 1 + maximumLength(ind + 1, ind, k - 1, dp, nums);
        }
        return dp[ind][prev + 1][k] = Math.max(taken, notTaken);
    }

    public static int maximumLength2d(int ind, int k, int[][] dp, int[] nums) {
        if (ind == nums.length || k < 0) return 0;

        if (dp[ind][k] != -1) return dp[ind][k];

        int ans = 0;
        for (int i = ind + 1; i < nums.length; ++i) {
            int notTaken = maximumLength2d(i, k, dp, nums);
            int taken = 0;
            if (nums[ind] == nums[i]) {
                taken = 1 + maximumLength2d(i, k, dp, nums);
            } else if (k > 0 && nums[ind] != nums[i]) {
                taken = 1 + maximumLength2d(i, k - 1, dp, nums);
            }
            ans = Math.max(ans, taken);
            ans = Math.max(ans, notTaken);
        }
        return dp[ind][k] = ans ;
    }

    public static int maximumLengthDP(int[] nums, int K) {
        int n = nums.length;
        int[][][] dp = new int[n + 1][n + 2][K + 1];

        for (int[][] i : dp) {
            for (int[] j : i) {
                Arrays.fill(j, 1);
            }
        }

        for (int ind = n - 1; ind >= 0; ind--) {
            for (int k = 0; k <= K; k++) {
                for (int prev = n - 1; prev >= 0; prev--) {
                    int notTaken = dp[ind + 1][prev][k];
                    int taken = 0;
                    if (prev == 0 || (nums[ind] == nums[prev])) {
                        taken = 1 + dp[ind + 1][ind][k];
                    } else if (k > 0 && nums[ind] != nums[prev]) {
                        taken = 1 + dp[ind + 1][ind][k - 1];

                    }
                    dp[ind][prev + 1][k] = Math.max(taken, notTaken);
                }
            }
        }
        return dp[0][0][K];
    }

    public static int maximumLength(int[] nums, int k) {
        int n = nums.length;
        int[][][] dp = new int[n + 1][n + 2][k + 1];
        for (int[][] i : dp) {
            for (int[] j : i) {
                Arrays.fill(j, -1);
            }
        }

        int[][] dp2 = new int[n + 1][k + 1];
        for (int[] i : dp2) Arrays.fill(i, -1);
//        int val = maximumLength(0, -1, k, dp, nums);
        int val = maximumLength2d(0, k, dp2, nums);
        ArrayImpl.print2dArr(dp2);
        return val;
    }

    public static void main(String[] args) {
//        String str = "cbDD34";
//        System.out.println(clearDigits(str));

//        int[] arr = {4, 2, 6, 3, 9};
//        int k = 2;
//        int[] arr = {2, 5, 4};
//        int k = 1;

//        int[] arr = {3, 10, 19, 2, 16, 14, 8, 17};
//        int k = 5;

//        int[] arr = {16, 14, 10, 13};
//        int k = 1;
//        System.out.println(findWinningPlayer(arr, k));

        int[] arr = {1, 2, 1, 1, 3};
        int k = 2;

//        int[] arr = {1, 2, 3, 4, 5, 1};
//        int k = 0;
        System.out.println(maximumLength(arr, k));
//        System.out.println(maximumLengthDP(arr, k));

    }
}
