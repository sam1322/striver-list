package Striver.BinarySearch;

public class searchElementinaRotatedSortedArray {
    public static int search(int[] arr, int target) {
        int n = arr.length;
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) >> 1;
            System.out.println(mid);
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[low] <= arr[mid]) {
                if (arr[low] <= target && target <= arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (arr[mid] <= target && target <= arr[high]) {
                    low = mid + 1;

                } else {
                    high = mid - 1;
                }
            }

        }
        return -1;

    }

    public static void main(String[] args) {
//        int[] arr = {8, 7, 9, 0, 1, 2, 3, 4};
//        int target = 9;
        int []arr ={3,1};
        int target =1 ;
        System.out.println(search(arr,target));
    }
}
