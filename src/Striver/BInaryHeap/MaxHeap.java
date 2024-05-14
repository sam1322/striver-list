package Striver.BInaryHeap;

public class MaxHeap {
    private int[] heapArray;
    private int capacity;

    private int currentHeapSize;

    public int getCurrentHeapSize(){
        return  currentHeapSize;
    }

    public int[] getHeapArray() {
        return heapArray;
    }

    public MaxHeap(int n) {
        capacity = n;
        heapArray = new int[capacity];
        currentHeapSize = 0;
    }

    private boolean isValidIndex(int index, int size) {
        boolean val = index < 0 || index >= size;
        return !val;
    }

    private boolean isValidIndex(int index) {
        boolean val = index < 0 || index >= heapArray.length || index >= currentHeapSize;
        return !val;
    }

    private void swap(int[] arr, int a, int b) {
        if (!isValidIndex(a, arr.length) || !isValidIndex(b, arr.length)) return;
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    private int parent(int key) {
        if (!isValidIndex(key)) return -1;
        return (key - 1) / 2;
    }

    // Get the Left Child index for the given index
    private int left(int key) {
        if (!isValidIndex(key)) return -1;
        return 2 * key + 1;
    }

    // Get the Right Child index for the given index
    private int right(int key) {
        if (!isValidIndex(key)) return -1;
        return 2 * key + 2;
    }

    public int getMax() {
        if (!isValidIndex(0)) return -1;
        return heapArray[0];
    }

    // Inserts a new key
    public boolean insertValue(int key) {
        if (currentHeapSize == capacity) {

            // heap is full
            return false;
        }

        // First insert the new key at the end
        int i = currentHeapSize;
        heapArray[i] = key;
        currentHeapSize++;

        heapifyParents(i);
        return true;
    }

    // This function deletes key at the
    // given index. It first reduced value
    // to minus infinite, then calls extractMin()
    public void deleteKey(int key) {
        decreaseKey(key, Integer.MAX_VALUE);
        extractMax();
    }

    public void decreaseKey(int key, int new_val) {
        if (!isValidIndex(key) || heapArray[key] < new_val) return;
        heapArray[key] = new_val;

        heapifyParents(key);
    }

    public void increaseKey(int key, int new_val) {
        if (!isValidIndex(key) || heapArray[key] > new_val) return;
        heapArray[key] = new_val;
        MaxHeapify(key);
    }


    // Method to remove minimum element
    // (or root) from min heap
    public int extractMax() {
        if (currentHeapSize <= 0) {
            return Integer.MIN_VALUE;
        }

        if (currentHeapSize == 1) {
            currentHeapSize--;
            int temp = heapArray[0];
            heapArray[0] = 0;
            return temp;
        }

        // Store the minimum value,
        // and remove it from heap
        int root = heapArray[0];

        heapArray[0] = heapArray[currentHeapSize - 1];
        heapArray[currentHeapSize - 1] = 0;
        currentHeapSize--;
        MaxHeapify(0);

        return root;
    }

    private void MaxHeapify(int key) {
        if (!isValidIndex(key)) return;
        int l = left(key);
        int r = right(key);

        int largest = key;
        if (isValidIndex(l) && heapArray[l] > heapArray[largest]) {
            largest = l;
        }
        if (isValidIndex(r) && heapArray[r] > heapArray[largest]) {
            largest = r;
        }

        if (largest != key) {
            swap(heapArray, key, largest);
            MaxHeapify(largest);
        }
    }

    private void heapifyParents(int key) {
        while (isValidIndex(key) && isValidIndex(parent(key)) && heapArray[key] > heapArray[parent(key)]) {
            swap(heapArray, key, parent(key));
            key = parent(key);
        }
    }
}
