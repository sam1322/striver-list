package Striver.SlidingWindow;

public class BinarySubarraysWithSum {
    public static int findCountSmallerOrEqualToK(int[] nums, int k) {
        if (k < 0) return 0;
        int l = 0, r = 0, sum = 0, cnt = 0, n = nums.length;
        while (r < n) {
            sum += nums[r];
            while (l < r && sum > k) {
                sum -= nums[l];
                l++;
            }
            if (sum <= k) {
                cnt += (r - l + 1);
            }
            r++;
        }
        return cnt;
    }

    public static int numSubarraysWithSum(int[] nums, int goal) {
        return findCountSmallerOrEqualToK(nums, goal) - findCountSmallerOrEqualToK(nums, goal - 1);
    }

    public static void main(String[] args) {

    }
}
