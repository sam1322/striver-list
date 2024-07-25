package Striver.BInaryHeap;

import java.util.PriorityQueue;

class KthLargest2 {
    private int K;
    private PriorityQueue<Integer> q;

    public KthLargest2(int k, int[] nums) {
        q = new PriorityQueue<>((a, b) -> b - a);
        for (int i : nums) q.add(i);
        K = k;
    }

    public int add(int val) {
        q.add(val);
        while(q.size() > 0 ){
            System.out.println(q.peek());
            System.out.println(q.poll());
        }
        return -1 ;
//        while (q.size() > K) q.poll();
//        if (q.isEmpty()) return -1;
//        return q.peek();
    }
}

public class KthLargestElementInStream {
    public static void main(String[] args) {
        int[] arr = {4, 5, 8, 2};
        int k = 3;
        KthLargest2 obj = new KthLargest2(k, arr);
        System.out.println(obj.add(2));
    }
}
