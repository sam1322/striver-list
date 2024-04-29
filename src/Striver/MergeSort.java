package Striver;

import java.util.Scanner;

public class MergeSort {

    private static void merge (int[] num,int low ,int high){
        int[] temp = new int[ high - low + 1];
        int i = low;
        int mid = low  + ( high -  low) / 2;
        int j = mid + 1  ;
        int k = 0 ;
        while(i <=mid && j <= high){
            if(num[i] < num[j]){
                temp[k++]  = num[i++];
            }
            else {
                    temp[k++]  = num[j++];
            }
        }
        while(i <= mid){
            temp[k++] = num[i++];
        }

        while(j <= high){
            temp[k++] = num[j++];
        }
        for(int m = low ; m <= high ; ++m ){
            num[m] = temp[m - low];
        }
    }
    private static void mergeSort(int[] num,int low,int high){
        if(low >= high) return;
//        if(low == high -1 ){
//            if(num[low] > num[high]){
//                swap(num,low,high);
//            }
//            return;
//        }
        int mid = low + (high - low) / 2 ;
        System.out.println("mid " + mid);
        mergeSort(num,low,mid);
        mergeSort(num,mid + 1 ,high);
        merge(num,low,high);
    }
    public static void MergeSort(int[] num) {
        mergeSort(num,0, num.length - 1);
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
        Scanner scanner = new Scanner(System.in);
//        System.out.print("Enter n : ");
//        int n = scanner.nextInt();
//
//        System.out.print("Now enter " + n + " numbers\n");
//        int[] num = new int[n];
//        for (int i = 0; i < n; ++i) {
//            num[i] = scanner.nextInt();
//        }
        int[] num = {68, 41, 73, 29, 84, 78, 33, 96, 35, 85};
        double startTime = System.nanoTime(); // or System.nanoTime();
        MergeSort(num);
        double endTime = System.nanoTime(); // or System.nanoTime();
        double elapsedTime = endTime - startTime;
//        System.out.println("startTime " + startTime);
//        System.out.println("endTime " + endTime);
//        System.out.println("ellapsed time in milliseconds " + elapsedTime +" ms");
        PrintArr(num);
//        swap(num,0,1);
//        PrintArr(num);

    }
}
