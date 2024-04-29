package Striver;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InsertionSort {

    public static void InsertionSort(int[] num){
        int t,n = num.length;
        for(int i = 0 ; i < n - 1 ; ++i ){
            int j = i ;
            while(j >= 0  && num[j] > num[j + 1 ]){
                t = num[j+1];
                num[j + 1] = num[j];
                num[j]  = t ;
                j--;
            }
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter n : ");
        int n = scanner.nextInt();

        System.out.print("Now enter " + n + " numbers\n");
        int[] num = new int[n];
        for(int i = 0 ; i < n ;++i){
            num[i] = scanner.nextInt();
        }
        InsertionSort(num);
        for(int i : num){
            System.out.print(i+ " ");
        }
    }
}
