package Striver.Arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSubsequence {
    public static int findLongestConsequtiveSubsequenceBySet(int[] nums) {
        int n = nums.length;
        if (n == 0) return n;
//        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int ans = 0;
        for (int it : set) {
            if (!set.contains(it - 1)) {
                int x = it;
                int cnt = 1;
                while (set.contains(x + 1)) {
                    cnt++;
                    x++;
                }
                ans = Math.max(ans, cnt);
            }
        }
        return ans;
    }

    public static int findLongestConsequtiveSubsequenceBySort(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        if (n == 0) return n;
        int ans = 0, cnt = 0, prev = Integer.MIN_VALUE;
        for (int i = 0; i < n; ++i) {
            if (prev == nums[i] - 1) {
                cnt++;
            } else if (prev != nums[i]) {
                cnt = 1;

            }
            prev = nums[i];
            ans = Math.max(cnt, ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(findLongestConsequtiveSubsequenceBySet(nums));
        System.out.println(findLongestConsequtiveSubsequenceBySort(nums));
    }
}
