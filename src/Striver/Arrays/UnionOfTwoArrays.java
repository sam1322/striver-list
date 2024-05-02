package Striver.Arrays;

import java.util.ArrayList;
import java.util.List;

public class UnionOfTwoArrays {

    public static List<Integer> Union(int[] arr1, int[] arr2) {
        List<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        int n = arr1.length;
        int m = arr2.length;
        while (i < n && j < m) {
            if (arr1[i] < arr2[j]) {
                insert(list, arr1[i++]);
            } else {
                insert(list, arr2[j++]);
            }
        }
        while(i<n){
            insert(list, arr1[i++]);

        }
        while(j<m){
            insert(list, arr2[j++]);

        }
        return list;
    }

   public static void PrintList(List<Integer> list) {
        for (Integer i : list) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void insert(List<Integer> list, int num) {
        if (list.isEmpty()) {
            list.add(num);
            return;
        }
        if (list.get(list.size() - 1) == num) return;
        list.add(num);
    }

    public static void main(String[] args) {
        int[] num = {1, 2, 3, 4, 5, 6, 7};
        int[] num2 = {1, 2, 3, 4, 4, 9};
        List<Integer> list = Union(num, num2);
        PrintList(list);
    }
}
