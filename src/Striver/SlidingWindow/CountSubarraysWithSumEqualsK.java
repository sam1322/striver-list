package Striver.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class CountSubarraysWithSumEqualsK {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        int sum = 0;
        int ans = 0;
        int n = nums.length;

        for (int i = 0; i < n; ++i) {
            sum += nums[i];
            if (mp.containsKey(sum - k)) {
                ans += mp.get(sum - k);
            }
            mp.put(sum, mp.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[]arr = {1,1,1};
    }
}
