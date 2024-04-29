package Striver;

public class RemoveDuplicates {

    public static int removeDuplicates(int[] num) {
        if (num.length == 0) return 0;
        int pos = -1;
        int k = 1;
        int n = num.length;
        for (int i = 1; i < n; ++i) {
            if (num[i] == num[i - 1] && pos == -1) {
                pos = i;
            } else if (num[i] != num[i - 1]) {
                if (pos != -1) {
                    num[pos++] = num[i];
                }
                k++;
            }
        }
        return k;
    }

    public static void PrintArr(int[] num) {
        for (int i : num) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

//        int[] num = {68, 41, 73, 29, 84, 78, 33, 96, 35, 85, 41};
        int[] num = {0,0,1,1,1,2,2,3,3,4};
//        int[] num = {0, 0, 1, 1, 2};

        int k = removeDuplicates(num);
        System.out.println("K = " + k);
        PrintArr(num);

    }
}
