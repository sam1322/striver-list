package Striver.BinarySearch;

public class MedianOfTwoSortedArrays {

    public static double findMedian(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;

        //if n1 is bigger swap the arrays:
        if (n > m) return findMedian(arr2, arr1);
        int l1, l2, r1, r2;
        int low = 0, high = n;
        int totalLength = n + m ;
        int left = (totalLength + 1) / 2;
        while (low <= high) {
            int mid1 = (low + high) >> 1;
            int mid2 = left - mid1 ;
             l1 = (mid1 > 0) ? arr1[mid1 - 1 ] : Integer.MIN_VALUE;
             l2 = (mid2 > 0 ) ? arr2[mid2 - 1] : Integer.MIN_VALUE;
             r1 = (mid1 < n) ? arr1[mid1] : Integer.MAX_VALUE;
             r2 = (mid2 < m ) ? arr2[mid2] : Integer.MAX_VALUE;
             if(l1 <= r2 && l2 <= r1){
                 if(totalLength%2 == 1) return Math.max(l1,l2);
                 else return ((double) (Math.max(l1, l2) + Math.min(r1, r2))) / 2.0;
             }else if (l1 > r2) high = mid1 - 1;
             else low = mid1 + 1;

        }
        return 0;
    }

    public static void main(String[] args) {
//        int[] arr1 = {1, 4, 7, 10, 12};
//        int[] arr2 = {2, 3, 6, 15};
        int[] arr1 = {1,3};
        int[] arr2 = {2};
        System.out.println(findMedian(arr1, arr2));
    }
}
