package Striver.BInaryHeap;

import Striver.Sorting.QuickSort;

import java.util.Arrays;

public class MaxHeapImpl {

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
        MaxHeap h = new MaxHeap(11);
        h.insertValue(3);
        h.insertValue(2);
        h.insertValue(1);
        h.deleteKey(1);
        h.insertValue(15);
        h.insertValue(5);
        h.insertValue(4);
        h.insertValue(45);
        System.out.print(h.extractMax() + " ");
        System.out.print(h.getMax() + " ");

        h.decreaseKey(2, 1);
        System.out.println(h.getMax());
        int[] arr = h.getHeapArray();
        System.out.print("Max heap ");
        int currentSize= h.getCurrentHeapSize();
        System.out.println("current Size" + currentSize);
        QuickSort.PrintArr(arr);
        int[] arr1 = Arrays.copyOfRange(arr,0,currentSize);
        QuickSort.PrintArr(arr1);
        System.out.println("is max heap " + countSub(arr1, arr1.length));
    }
}
