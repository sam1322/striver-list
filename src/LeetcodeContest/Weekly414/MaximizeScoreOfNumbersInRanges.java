package LeetcodeContest.Weekly414;

import java.util.Arrays;

public class MaximizeScoreOfNumbersInRanges {
    public static int maxPossibleScore(int[] start, int d) {
        int ans = 0;
        int low = 0;
        int high = Integer.MAX_VALUE;
        Arrays.sort(start);

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isValid(mid, start, d)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    private static boolean isValid(int mid, int[] start, int d) {
        int prev = start[0];
        for (int i = 1; i < start.length; ++i) {
            if (prev + mid > start[i] + d) return false;
            prev = Math.max(prev + mid, start[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        int start[] = {2, 6, 13, 13}, d = 5;
        start = new int[]{1000000000, 0};
        d = 1000000000;
        System.out.println(maxPossibleScore(start, d));
    }
}
