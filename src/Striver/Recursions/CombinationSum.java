package Striver.Recursions;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    private static void combinationSum(int index, int target, int[] nums, List<Integer> curr, List<List<Integer>> totalList) {
        if (target == 0) {
            totalList.add(new ArrayList<>(curr));
            return;
        }
        if (index >= nums.length) {
            return;
        }
        if (nums[index] <= target) {
            curr.add(nums[index]);
            combinationSum(index, target - nums[index], nums,curr, totalList);
            curr.remove(curr.size() - 1);
        }
        combinationSum(index + 1,target,nums,curr,totalList);
    }

    public static List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> totalList = new ArrayList<>();
        combinationSum(0, target, nums, new ArrayList<>(), totalList);
        return totalList;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 7};
        int target = 7;
        List<List<Integer>> list = combinationSum(arr, target);
        System.out.println(list);
    }
}
