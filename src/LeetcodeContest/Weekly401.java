package LeetcodeContest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Weekly401 {
    public static int numberOfChild(int n, int k) {
        int l = 0, f = 1;
        for (int i = 1; i <= k; ++i) {
            if (l == 0) {
                f = 1;
                l += f;
            } else if (l == n - 1) {
                f = -1;
                l += f;
            } else if (l > 0 && l < n - 1) {
                l += f;
            }
//            System.out.println(i + " : " + l  + " : " + f);
        }

        return l;
    }

    public static int mod = 1000000007;

    public static int valueAfterKSeconds(int n, int k) {
        int[] arr = new int[n];
        Arrays.fill(arr, 1);
        for (int i = 1; i <= k; ++i) {
            int sum = 0;
            for (int j = 0; j < n; ++j) {
                arr[j] = (arr[j] + sum) % mod;
                sum = arr[j];
            }
        }
        return arr[n - 1] % mod;
    }

    public static int maxReward(int ind, int x, int[] arr, long[][] dp) {
        if (ind >= arr.length) return 0;
        String key = ind + ":" + x;
        if (dp[ind][x] != -1) return (int) dp[ind][x];
        int notTaken = maxReward(ind + 1, x, arr, dp);
        int taken = 0;
        if (x < arr[ind]) {
            taken = arr[ind] + maxReward(ind + 1, x + arr[ind], arr, dp);
        }
        int val = Math.max(taken, notTaken);
        dp[ind][x] = val;
        return val;
    }

    public static int maxReward(int ind, int x, int[] arr, Map<String, Integer> mp) {
        if (ind >= arr.length) return 0;
//        String key = ind + ":" + x;
        String key = ind + ":" + x;

        if (mp.containsKey(key)) {
            System.out.println("hello");
            return mp.get(key);
        }
        ;
        int notTaken = maxReward(ind + 1, x, arr, mp);
        int taken = 0;
        if (x < arr[ind]) {
            taken = arr[ind] + maxReward(ind + 1, x + arr[ind], arr, mp);
        }
        int val = Math.max(taken, notTaken);
        mp.put(key, val);
        return val;
    }

    public static int maxTotalReward(int[] rewardValues) {
        Map<String, Integer> mp = new HashMap<>();
        Arrays.sort(rewardValues);
        int n = rewardValues.length;
        long[][] dp = new long[n][100000];
        for (long[] i : dp) Arrays.fill(i, -1);
        int val = maxReward(0, 0, rewardValues, dp);
        return val;
    }

    public static void main(String[] args) {
//        System.out.println(numberOfChild(3, 5));
//        System.out.println(numberOfChild(5, 6));
//        System.out.println(numberOfChild(4, 2));

//        System.out.println(valueAfterKSeconds(4, 5));
//        System.out.println(valueAfterKSeconds(5, 3));

        int[] arr = {1, 1, 3, 3};
        System.out.println(maxTotalReward(arr));
        int[] arr1 = {1, 6, 4, 3, 2};
        System.out.println(maxTotalReward(arr1));

    }
}
