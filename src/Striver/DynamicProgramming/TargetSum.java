package Striver.DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class TargetSum {

    private static int func(int n, int target, int[] nums, Map<String, Integer> mp) {
        int ans = 0;

        if (n == 0) {
            if (target + nums[0] == 0) ans++;
            if (target - nums[0] == 0) ans++;
            return ans;
        }
        String key = n + ":" + target;
        if (mp.containsKey(key)) return mp.get(key);
        ans = func(n - 1, target - nums[n], nums, mp) + func(n - 1, target + nums[n], nums, mp);
        mp.put(key, ans);
        return ans;
    }

    public static int findTargetSumWays(int[] nums, int target) {
        Map<String, Integer> mp = new HashMap<>();
        return func(nums.length - 1, target, nums, mp);
    }

    public static void main(String[] args) {
//        int[] arr = {1, 2, 3, 1};
//        int target = 3;
        int[] arr = {1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(findTargetSumWays(arr, target));
    }
}
