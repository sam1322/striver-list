package Striver.Arrays;

import Striver.Sorting.QuickSort;

public class RotateArray {

    public static void reverse(int []num,int start,int end){
        while(start < end){
            int temp = num[start];
            num[start] = num[end];
            num[end] = temp;
            start++;
            end--;
        }
    }

    public static  void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] arr = new int[n];
        k = k % n;
        int pos = n - k ;
        reverse(nums,0,pos - 1);
        reverse(nums,pos,n - 1);
        reverse(nums,0,n-1);
//        for (int i = 0; i < n; i++) {
//            int pos = (n + i - k) % n;
//            arr[i] = nums[pos];
//        }
//        for(int i = 0 ; i < n ; ++i){
//            nums[i] = arr[i];
//        }
    }

    public static void main(String[] args) {
        int[] num = {1, 2, 3, 4, 5, 6, 7};

        int k = 3;
//        int[] num = {0, 0, 1, 1, 2};

//        int k = removeDuplicates(num);
//        System.out.println("K = " + k);
        rotate(num,k);
        QuickSort.PrintArr(num);
    }
}
