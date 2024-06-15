package Striver.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class LongestDivisibleSubset {

    public static int printLds(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int[] hash = new int[n];
        Arrays.fill(hash, 1);
        Arrays.sort(nums);
        for (int i = 0; i <= n - 1; i++) {
            hash[i] = i; // initializing with current index
            for (int prev_index = 0; prev_index <= i - 1; prev_index++) {
                if (nums[i] % nums[prev_index] == 0  && 1 + dp[prev_index] > dp[i]) {
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
        Collections.reverse(temp);
//        for (int i = temp.size() - 1; i >= 0; i--) {
//            System.out.print(temp.get(i) + " ");
//        }
        System.out.println(temp);

        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {1,16,7,8,4};
        printLds(arr);
    }
}
