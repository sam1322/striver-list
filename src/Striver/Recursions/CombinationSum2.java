package Striver.Recursions;

import java.util.*;

public class CombinationSum2 {
    private static void combinationSum2(int index, int target, int[] nums, List<Integer> curr, List<List<Integer>> totalList, Set<String> set) {
        if (target == 0) {
            if(set.contains(curr.toString())) return;
            totalList.add(new ArrayList<>(curr));
            set.add(curr.toString());
            return;
        }
        if (index >= nums.length) {
            return;
        }
        if (nums[index] <= target) {
            curr.add(nums[index]);
            combinationSum2(index + 1, target - nums[index], nums, curr, totalList,set);
            curr.remove(curr.size() - 1);
        }
        index++;
        while(index < nums.length && nums[index] == nums[index - 1] ) index++;
        combinationSum2(index, target, nums, curr, totalList,set);
    }

    public static List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> totalList = new ArrayList<>();
        Arrays.sort(nums);
        Set<String> set = new HashSet<>();
        combinationSum2(0, target, nums, new ArrayList<>(), totalList ,set);
        return totalList;
    }

    public static void main(String[] args) {
//        int[] arr = {10, 1, 2, 7, 6, 1, 5};
//        int target = 8;
        int[] arr = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        int target = 30;
        List<List<Integer>> list = combinationSum2(arr, target);
        System.out.println(list);
    }
}
