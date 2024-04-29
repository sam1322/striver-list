package Striver;

import java.util.Scanner;

public class QuickSort {
    private static int partition (int[] num,int low ,int high){
      int pivot = num[low];
      int i =  low;
      int j =  high;
      while(i<j){
          while( num[i] <= pivot && i < high){
            i++;
          }
          while( num[j] > pivot && j > low){
              j--;
          }
          if( i <  j ){
              swap(num,i,j);
          }
      }
      swap(num,low,j);
      return j;
    }
    private static void quickSort(int[] num,int low,int high){
        if(low >= high) return;
        int pIndex = partition(num,low,high);
        quickSort(num,low,pIndex - 1  );
        quickSort(num,pIndex + 1 ,high);
    }
    public static void QuickSortFn(int[] num) {
        quickSort(num,0, num.length - 1);
    }

    public static void swap(int[] num, int a, int b) {
        int n = num.length;
        if (a >= n || a < 0 || b >= n || b < 0) return;
        int t = num[a];
        num[a] = num[b];
        num[b] = t;
        System.out.println("swapped a = " + a + " b " + b);
    }

    public static void PrintArr(int[] num) {
        for (int i : num) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int[] num = {68, 41, 73, 29, 84, 78, 33, 96, 35, 85 , 41};

        QuickSortFn(num);

        PrintArr(num);

    }
}
