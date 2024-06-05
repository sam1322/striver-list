package Striver.Arrays;

public class ArrayImpl {
    public static void printArr(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void print2dArr(int[][] arr) {
        for (int[] i : arr) {
            for (int j : i)
                System.out.print(j + " ");
            System.out.println();

        }
    }
    public static <T> void print2dArr(T[][] arr) {
        for (T[] i : arr) {
            for (T j : i)
                System.out.print(j + " ");
            System.out.println();

        }
    }

    public static void print2dArrlong(long[][] arr) {
        for (long[] i : arr) {
            for (long j : i)
                System.out.print(j + " ");
            System.out.println();

        }
    }
}
