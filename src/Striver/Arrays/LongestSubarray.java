package Striver.Arrays;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarray {
    public static int longestSubarray(int[] nums, int k) {
        Map<Long, Integer> mp = new HashMap<>();
        long sum = 0;
        int ctr = 0;
//        for (int i : nums) {
//            sum += i;
//            mp.put(sum, index++);
//        }

        int n = nums.length;
        long mx = 0;
        sum = 0;
        for (int i = 0; i < n; ++i) {
            sum += nums[i];
            if (sum == k) {
                mx = Math.max(mx, i + 1);
                ctr++;
            }
            if (mp.containsKey(sum - k)) {
                mx = Math.max(mx, i - mp.get(sum - k));
                ctr++;
            }
            if (!mp.containsKey(sum)) {
                mp.put(sum, i);
            }
        }
        return ctr;
//        return mx;
    }


    public static int getLongestSubarray_StriverSoln(int[] a, long k) {
        int n = a.length; // size of the array.

        int left = 0, right = 0; // 2 pointers
        long sum = a[0];
        int maxLen = 0;
        while (right < n) {
            // if sum > k, reduce the subarray from left
            // until sum becomes less or equal to k:
            while (left <= right && sum > k) {
                sum -= a[left];
                left++;
            }

            // if sum = k, update the maxLen i.e. answer:
            if (sum == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }

            // Move forward thw right pointer:
            right++;
            if (right < n) sum += a[right];
        }

        return maxLen;
    }


    public static void main2() {
        int[] a = {2, 3, 5, 1, 9};
        long k = 10;
        int len = getLongestSubarray_StriverSoln(a, k);
        System.out.println("The length of the longest subarray is: " + len);
    }


    public static void main(String[] args) {
//        int[] num = {2, 3, 5, 1, 9};
//        int[] num = {1, 2, 3, 1, 1, 1, 1};
//        int[] num = { 1, 2, 3};
        int[] num = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int k = 0;
        int mx = longestSubarray(num, k);
        System.out.println("mx = " + mx);
//        List<Integer> list = Union(num, num2);
//        PrintList(list);
        main2();
    }
}
