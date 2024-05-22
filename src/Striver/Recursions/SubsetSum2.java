package Striver.Recursions;

import java.util.*;

public class SubsetSum2 {

    private static void subsets(int index, int[] nums, List<Integer> curr, List<List<Integer>> subsetArr) {
        subsetArr.add(new ArrayList<>(curr));
        for (int i = index; i < nums.length; ++i) {
            if (i != index && nums[i] == nums[i - 1]) continue;
            curr.add(nums[i]);
            subsets(i + 1, nums, curr, subsetArr);
            curr.remove(curr.size() - 1);
        }
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
//        for(int i : nums)
//            System.out.print(i+" ");
//        System.out.println();
        List<List<Integer>> subsetsArr = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        subsets(0, nums, arr, subsetsArr);
        return subsetsArr;
    }


    public static void main(String[] args) {
//        int[] arr = {1, 2 , 2};
        int[] arr = {4, 4, 4, 1, 4};
        List<List<Integer>> list = subsetsWithDup(arr);
//        System.out.println(list);
        for (List<Integer> i : list) {
            System.out.println(i.toString());
        }
    }
}
