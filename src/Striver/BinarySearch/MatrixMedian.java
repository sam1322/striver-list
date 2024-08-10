package Striver.BinarySearch;

public class MatrixMedian {
    public static int countSmallerThanEqualToMid(int[] row, int mid) {
        int l = 0, h = row.length - 1;
        while (l <= h) {
            int md = (l + h) >> 1;
            if (row[md] <= mid) {
                l = md + 1;
            } else {
                h = md - 1;
            }
        }
        return l;
    }

    public static int findMedian(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int low = 1;
        int high = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = (low + high) >> 1;
            int cnt = 0;
            for (int i = 0; i < n; ++i) {
                cnt += countSmallerThanEqualToMid(arr[i], mid);
            }
            if (cnt <= (n * m) / 2) low = mid + 1;
            else high = mid - 1;

        }
        return low;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,4,9},{2,5,6},{3,8,9}};
        System.out.println(findMedian(arr));
    }
}
