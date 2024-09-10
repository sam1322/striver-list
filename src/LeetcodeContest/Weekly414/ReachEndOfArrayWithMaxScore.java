package LeetcodeContest.Weekly414;

import java.util.List;

public class ReachEndOfArrayWithMaxScore {
    public static long findMaximumScore1(List<Integer> nums) {
        int n = nums.size();
        long score = 0;
        int prev = 0;
        for (int i = 1; i < n; ++i) {
            if (nums.get(i) > nums.get(prev)) {
                score += (long) (i - prev) * (nums.get(prev));
                prev = i;
            }
        }
        if (prev != n - 1) {
            score += (long) (n - 1 - prev) * (nums.get(prev));
        }

        return score;
//        long[] score = new long[n];
//        for (int j = 1; j < n; ++j) {
//            for (int i = 0; i < j; ++i) {
//                long cur = (j - i) * nums.get(i);
//                score[j] = Math.max(score[j], score[i] + cur);
//            }
//        }
//        return score[n - 1];
    }

    public static void main(String[] args) {
        Integer[] arr = {4,3,1,3,2};
//        Integer[] arr = {1, 3, 1, 5};
        System.out.println(findMaximumScore1(List.of(arr)));
    }
}
