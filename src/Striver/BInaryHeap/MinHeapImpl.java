package Striver.BInaryHeap;

import Striver.Sorting.QuickSort;

public class MinHeapImpl {

    public static boolean countSub(int[] arr, long n) {
        int i = 0;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        while (i < n && l < n) {
            if (arr[l] > arr[i] || (r < n && arr[r] > arr[i])) {
                return false;
            }
            i++;
            l=2*i+ 1;
            r = 2*i+2;

        }
        return true;
        // Your code goes here
    }

    public static void main(String[] args) {
        MinHeap h = new MinHeap(11);
        h.insertValue(3);
        h.insertValue(2);
        h.insertValue(1);
        h.deleteKey(1);
        h.insertValue(15);
        h.insertValue(5);
        h.insertValue(4);
        h.insertValue(45);
        System.out.print(h.extractMin() + " ");
        System.out.print(h.getMin() + " ");

        h.decreaseKey(2, 1);
        System.out.println(h.getMin());
        int[] arr = h.getHeapArray();
        System.out.print("Max heap ");
        QuickSort.PrintArr(arr);
        System.out.println("is max heap " + countSub(arr,arr.length));
    }
}
