package Striver.Stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class SlidingWindowMaximum {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] soln = new int[n - k + 1];
        int j = 0;

        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < n; ++i) {
            if (!dq.isEmpty() && dq.peek() == i - k) dq.poll();

            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) dq.pollLast();

            dq.add(i);

            if (i >= k - 1) soln[j++] = nums[dq.peek()];
        }
        return soln;
    }

    public static void main(String[] args) {
        int i, j, n, k = 3, x;
        int arr[] = {4, 0, -1, 3, 5, 3, 6, 8};
        int ans[] = maxSlidingWindow(arr, k);
        System.out.println("Maximum element in every " + k + " window ");
        for (i = 0; i < ans.length; i++)
            System.out.print(ans[i] + "  ");
    }
}
