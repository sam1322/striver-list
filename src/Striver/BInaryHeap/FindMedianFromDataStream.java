package Striver.BInaryHeap;

import java.util.*;

class MedianFinder {
    //    List<Integer> list;
    private PriorityQueue<Integer> mn;
    private PriorityQueue<Integer> mx;
    private boolean even = true;

    public MedianFinder() {
        mn = new PriorityQueue<>();
        mx = new PriorityQueue<>((a, b) -> b - a);
    }

    public void addNum(int num) {
        if (even) {
            mn.add(num);
            mx.add(mn.poll());
        } else {
            mx.add(num);
            mn.add(mx.poll());
        }
        even = !even;
//        mn.add(num);
//        int totalSize = mn.size() + mx.size();
//        if (totalSize % 2 == 0) {
//            while (mn.size() > mx.size()) {
//                mx.add(mn.poll());
//            }
//        } else {
//            while (mn.size() > mx.size() + 1) {
//                mx.add(mn.poll());
//            }
//        }
    }

    public double findMedian() {
        if (even) {
            return (mn.peek() + mx.peek()) / 2.0;
        }
        return mn.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
public class FindMedianFromDataStream {

    public static void main(String[] args) {
        MedianFinder obj = new MedianFinder();
        obj.addNum(1);
        obj.addNum(6);
        System.out.println(obj.findMedian());
        obj.addNum(5);
        obj.addNum(3);
        obj.addNum(4);
        obj.addNum(2);

        System.out.println(obj.findMedian());
    }
}
