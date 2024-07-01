package Striver.Arrays;

import java.util.Arrays;

public class MergeTwoSortedArrays {
    public static void merge(long[] arr1, long[] arr2, int n, int m) {

        // Declare 2 pointers:
        int left = n - 1;
        int right = 0;

        // Swap the elements until arr1[left] is
        // smaller than arr2[right]:
        while (left >= 0 && right < m) {
            if (arr1[left] > arr2[right]) {
                long temp = arr1[left];
                arr1[left] = arr2[right];
                arr2[right] = temp;
                left--;
                right++;
            } else {
                break;
            }
        }

        // Sort arr1[] and arr2[] individually:
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }

    public static void swapIfGreater(long[] arr1, long[] arr2, int ind1, int ind2) {
        if (arr1[ind1] > arr2[ind2]) {
            long temp = arr1[ind1];
            arr1[ind1] = arr2[ind2];
            arr2[ind2] = temp;
        }
    }

    public static void merge2(long[] arr1, long[] arr2, int n, int m) {
        int len = n + m;
        int gap = Math.ceilDiv(len, 2);
        for(;gap>0;gap=Math.ceilDiv(gap,2)){
            int left = 0 ;
            int right = left+gap;
            while(right < len ){
                // case 1 : when both elements are in arr1
                if(left < n && right < n){
                    swapIfGreater(arr1, arr1, left, right);
                }
                // case 2 : when one element is in arr1 and other in arr2
                else if(left < n && right >= n){
                    swapIfGreater(arr1, arr2, left, right-n);
                }
                // case 3 : when both elements are in arr2
                else{
                    swapIfGreater(arr2, arr2, left-n, right-n);
                }
                left++; right++;
            }
            // break if iteration gap=1 is completed:
            if (gap == 1) break;
        }

    }

    public static void main(String[] args) {
        long[] arr1 = {1, 4, 8, 10};
        long[] arr2 = {2, 3, 9};
        int n = 4, m = 3;
        merge2(arr1, arr2, n, m);
        System.out.println("The merged arrays are:");
        System.out.print("arr1[] = ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.print("\narr2[] = ");
        for (int i = 0; i < m; i++) {
            System.out.print(arr2[i] + " ");
        }
        System.out.println();
    }
}
