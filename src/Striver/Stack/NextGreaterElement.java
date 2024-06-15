package Striver.Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> mp = new HashMap<>();
        int n = nums1.length;
//        for(Integer i:nums1) mp.put(i,-1);
        Stack<Integer> stack = new Stack<>();
        for (int cur : nums2) {
            if (stack.empty()) {
                stack.push(cur);
            } else {
                while (!stack.isEmpty() && stack.peek() < cur) {
                    mp.put(stack.pop(), cur);
                }
                stack.push(cur);
            }
        }
        while (!stack.empty()) mp.put(stack.pop(), -1);
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = mp.get(nums1[i]);
        }
        return arr;
    }

    public static int[] nextGreaterElement_Striver(int[] nums) {
        int n = nums.length;
        int nge[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (st.isEmpty() == false && st.peek() <= nums[i % n]) {
                st.pop();
            }

            if (i < n) {
                if (st.isEmpty() == false) nge[i] = st.peek();
                else nge[i] = -1;
            }

            st.push(nums[i % n]);
        }
        return nge;
    }

    public static int[] nextGreaterElementCircular_Striver(int[] nums) {
        int n = nums.length;
        int nge[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 2 * n - 1; i >= 0; i--) {
            while (st.isEmpty() == false && st.peek() <= nums[i % n]) {
                st.pop();
            }

            if (i < n) {
                if (st.isEmpty() == false) nge[i] = st.peek();
                else nge[i] = -1;
            }

            st.push(nums[i % n]);
        }
        return nge;
    }

    public static void printArr(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        printArr(nextGreaterElement(nums1, nums2));
        printArr(nextGreaterElement_Striver(nums2));
        printArr(nextGreaterElementCircular_Striver(nums2));
    }
}
