package Striver.Stack;

import java.util.List;
import java.util.Stack;

public class LargestRectangleInHistogram {
    public static int largestRectangleArea(int[] heights) {
        int n = heights.length, index = -1;
        Stack<Integer> st = new Stack<>();
        int[] leftSmallerArr = new int[n];
        int[] rightSmallerArr = new int[n];
        for (int i = 0; i < n; ++i) {
            while (!st.empty() && heights[st.peek()] >= heights[i]) st.pop();
            if (st.empty()) {
                index = 0;
            } else {
                index = st.peek() + 1;
            }
            leftSmallerArr[i] = index;
            st.push(i);
        }
        st = new Stack<>();
        for (int i = n - 1; i >= 0; --i) {
            while (!st.empty() && heights[st.peek()] >= heights[i]) st.pop();
            if (st.empty()) {
//                index = n - 1 ;
                index = n;
            } else {
                index = st.peek();
//                index = st.peek() - 1;
            }
            rightSmallerArr[i] = index;
            st.push(i);
        }
        for(int i : leftSmallerArr) System.out.print(i + " ");
        System.out.println();
        for(int i : rightSmallerArr) System.out.print(i + " ");
        System.out.println();
        int mx = 0;
        for (int i = 0; i < n; ++i) {
            mx = Math.max(mx, (rightSmallerArr[i] - leftSmallerArr[i]) * heights[i] );
        }
        return mx;
    }

    public static void main(String[] args) {
        int[] heights = {0,9};
        System.out.println(largestRectangleArea(heights));
    }
}
