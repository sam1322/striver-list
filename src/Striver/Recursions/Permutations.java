package Striver.Recursions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
    public static void permute(int[] nums, boolean[] freq, List<Integer> curr, List<List<Integer>> list) {
        if (curr.size() == nums.length) {
            list.add(new ArrayList<>(curr));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (freq[i]) continue;
            freq[i] = true;
            curr.add(nums[i]);
            permute(nums, freq, curr, list);
            curr.remove(curr.size() - 1);
            freq[i] = false;
        }

    }

    private static void recurPermute(int index, int[] nums, List<List<Integer>> ans) {
        if (index == nums.length) {
            // copy the ds to ans
            List<Integer> ds = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                ds.add(nums[i]);
            }
//            ans.add(new ArrayList<>(ds));
            ans.add(ds);

            return;
        }
        for (int i = index; i < nums.length; i++) {
            swap(i, index, nums);
            recurPermute(index + 1, nums, ans);
            swap(i, index, nums);
        }
    }

    private static void swap(int i, int j, int[] nums) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static List<List<Integer>> permuteBetter(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        recurPermute(0, nums, ans);
        return ans;
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        boolean[] freq = new boolean[nums.length];
        permute(nums, freq, new ArrayList<>(), list);
        return list;
    }

    public static void main(String[] args) {
        int[] num = {1, 2, 3};
        List<List<Integer>> list = permuteBetter(num);
        System.out.println(list);
    }
}
