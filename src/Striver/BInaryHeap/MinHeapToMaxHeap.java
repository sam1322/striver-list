package Striver.BInaryHeap;

public class MinHeapToMaxHeap {

    // shift down operation
    private static void MaxHeapify(int key, int[] heapArray) {
        int n = heapArray.length;

        int l = 2 * key + 1;
        int r = 2 * key + 2;

        int largest = key;
        if (l < n && heapArray[l] > heapArray[largest]) {
            largest = l;
        }
        if (r < n && heapArray[r] > heapArray[largest]) {
            largest = r;
        }

        if (largest != key) {
            swap(heapArray, key, largest);
            MaxHeapify(largest, heapArray);
        }
    }

    private static void swap(int[] arr, int a, int b) {
        if (!isValidIndex(a, arr.length) || !isValidIndex(b, arr.length)) return;
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    private static boolean isValidIndex(int index, int size) {
        boolean val = index < 0 || index >= size;
        return !val;
    }

    static void convertMinToMaxHeap(int N, int arr[]) {
        // code here
        for (int i = (N - 1) / 2; i >= 0; i--) {
            MaxHeapify(i, arr);
        }
    }
}
