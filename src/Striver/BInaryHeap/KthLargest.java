package Striver.BInaryHeap;

import Striver.Sorting.QuickSort;

import java.util.PriorityQueue;

public class KthLargest {
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> Integer.compare(y, x));
        for (int i : nums) pq.add(i);
        int n = nums.length;
        for (int i = n - 1; i > n - k; --i) {
            int a = pq.poll();
        }
        return pq.peek();
    }

    public static int findKthLargest2(int[] nums, int k) {
        int left = 0, right = 0, n = nums.length;
        right = n - 1;
        int kIndex = n - k;
        while (left <= right) {
            int pos = QuickSort.partition(nums, left, right);
            if (pos == kIndex) {
                return nums[pos];
            } else if (pos < kIndex) {
                left = pos + 1;
            } else right = pos - 1;
        }
        return -1;
    }

    public static int findKthLargest3(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : nums) {
            pq.add(i);
            while (pq.size() > k) pq.poll();
        }
        return pq.peek();
    }


    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println(findKthLargest(arr, k));
        System.out.println(findKthLargest2(arr, k));
        System.out.println(findKthLargest3(arr, k));
    }
}
