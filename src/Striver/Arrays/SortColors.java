package Striver.Arrays;

import Striver.Sorting.QuickSort;

public class SortColors {
    public static void sortColors(int[] nums) {
        int a = 0, b = 0, c = 0;
        for (int i : nums) {
            a += i == 0 ? 1 : 0;
            b += i == 1 ? 1 : 0;
            c += i == 2 ? 1 : 0;
        }
        int i = 0, n = nums.length;
        System.out.println("n " + n);
        System.out.println("a " + a);
        System.out.println("b " + b);
        System.out.println("c " + c);
        while (a > 0) {
            nums[i++] = 0;
            a--;
        }

        while (b > 0) {
            nums[i++] = 1;
            b--;
        }
        while (c > 0) {
            nums[i++] = 2;
            c--;
        }
    }

    public static void main(String[] args) {
        int[] num = {1, 2, 1, 1, 2, 0, 0, 0};

        int k = 3;
        sortColors(num);
        QuickSort.PrintArr(num);
    }
}
