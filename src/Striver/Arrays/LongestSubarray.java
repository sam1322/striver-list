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
    }
}
