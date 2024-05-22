package Striver.Recursions;

import java.util.ArrayList;
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

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        boolean[] freq = new boolean[nums.length];
        permute(nums, freq, new ArrayList<>(), list);
        return list;
    }

    public static void main(String[] args) {
        int[] num = {1, 2, 3};
        List<List<Integer>> list = permute(num);
        System.out.println(list);
    }
}
