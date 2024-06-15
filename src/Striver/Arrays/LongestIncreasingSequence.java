package Striver.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestIncreasingSequence {
    public static int lis(int index, int prev, int[] nums, int[][] dp) {
        if (index == nums.length) return 0;
        if (dp[index][prev + 1] != -1) return dp[index][prev + 1];
        int notTaken = 0 + lis(index + 1, prev, nums, dp);
        int taken = 0;
        if (prev == -1 || (nums[prev] < nums[index] && index != prev)) {
            taken = 1 + lis(index + 1, index, nums, dp);
        }
        return dp[index][prev + 1] = Math.max(notTaken, taken);

    }

    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n + 1];
        for (int[] i : dp) Arrays.fill(i, -1);
        int val = lis(0, -1, nums, dp);
//        ArrayImpl.print2dArr(dp);
        return val;
    }

    public static int lengthOfLIS_DP(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 1][n + 1];
        for (int ind = n - 1; ind >= 0; ind--) {
            for (int prevInd = ind - 1; prevInd >= -1; prevInd--) {
                int len = 0 + dp[ind + 1][prevInd + 1];
                if (prevInd == -1 || nums[ind] > nums[prevInd]) {
                    len = Math.max(len, 1 + dp[ind + 1][ind + 1]);
                }
                dp[ind][prevInd + 1] = len;
            }
        }

        return dp[0][0];
    }

    public static int printLis(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int[] hash = new int[n];
        Arrays.fill(hash,  1);
        for (int i = 0; i <= n - 1; i++) {
            hash[i] = i; // initializing with current index
            for (int prev_index = 0; prev_index <= i - 1; prev_index++) {
                if (nums[prev_index] < nums[i] && 1 + dp[prev_index] > dp[i]) {
                    dp[i] = 1 + dp[prev_index];
                    hash[i] = prev_index;
                }
            }
        }
        int ans = -1;
        int lastIndex = -1;

        for (int i = 0; i <= n - 1; i++) {
            if (dp[i] > ans) {
                ans = dp[i];
                lastIndex = i;
            }
        }

        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(nums[lastIndex]);

        while (hash[lastIndex] != lastIndex) { // till not reach the initialization value
            lastIndex = hash[lastIndex];
            temp.add(nums[lastIndex]);
        }

        // reverse the array

        System.out.print("The subsequence elements are ");

        for (int i = temp.size() - 1; i >= 0; i--) {
            System.out.print(temp.get(i) + " ");
        }
        System.out.println();

        return ans;
    }

    public static int bsearch(List<Integer> list, int k) {
        int low = 0;
        int high = list.size();
        while (low < high) {
            int mid = low + (high - low) / 2;
            int val = list.get(mid);
            if (val < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        if (low < list.size() && list.get(low) < k) {
            low++;
        }
        return low;
    }


    public static int lisBS(int[] arr) {
        int n = arr.length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            int ind = bsearch(list,arr[i]);
            if(ind>=list.size()){
                list.add(arr[i]);
            }
            else{
                list.set(ind,arr[i]);
            }
        }
        System.out.println(list);
        return list.size();

    }

    public static void main(String[] args) {
        int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};
//        System.out.println(lengthOfLIS(arr));
//        System.out.println(lengthOfLIS_DP(arr));
//        System.out.println(printLis(arr));
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 7, 8, 12, 15));
        System.out.println(bsearch(list, 16));
        System.out.println(lisBS(arr));
    }
}
