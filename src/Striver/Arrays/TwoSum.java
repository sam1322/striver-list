package Striver.Arrays;

import java.util.ArrayList;
import java.util.List;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int[] ans = new int[]{-1, -1};
        int n = nums.length;
        List<Integer[]> list = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            list.add(new Integer[]{nums[i], i});
        }
        list.sort((a, b) -> a[0] - b[0]);
        int i = 0;
        int j = n - 1;
        while (i < j) {
            int sum = list.get(i)[0] + list.get(j)[0];
            if (sum == target) {
                return new int[]{list.get(i)[1], list.get(j)[1]};
            } else if (sum < target) {
                i++;
            } else j--;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] num = {2, 7, 11, 15};
        int target = 9;
        int[] ans = twoSum(num, target);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }
}
