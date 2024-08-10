package Striver.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class SubarrayWithKDifferentIntegers {
    public static int findCountLessThanOrEqualToK(int[] nums, int k) {
        int n = nums.length;
        int l = 0, r = 0, cnt = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        while (r < n) {
            mp.put(nums[r], mp.getOrDefault(nums[r], 0) + 1);
            while (mp.size() > k) {
                decrement(nums, mp, l);
                l++;
            }
            if (mp.size() <= k) {
                cnt += (r - l + 1);
            }
            r++;
        }
        return cnt;
    }

    private static void decrement(int[] nums, Map<Integer, Integer> mp, int l) {
        mp.put(nums[l], mp.get(nums[l]) - 1);
        if (mp.get(nums[l]) == 0) mp.remove(nums[l]);
    }

    public static int subarraysWithKDistinct(int[] nums, int k) {
        return findCountLessThanOrEqualToK(nums, k) - findCountLessThanOrEqualToK(nums, k - 1);
    }

    public static void main(String[] args) {

    }
}
