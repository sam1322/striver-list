package Striver.DynamicProgramming;

public class MaximumProductSubarray {
    public static int maxProduct(int[] arr) {
        int n = arr.length; //size of array.

        long pre = 1, suff = 1;
        long ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (pre == 0) pre = 1;
            if (suff == 0) suff = 1;
            //for handling overflow
            if (pre * arr[i] > Integer.MAX_VALUE || pre * arr[i] < Integer.MIN_VALUE) continue;
            if (suff * arr[n - i - 1] > Integer.MAX_VALUE || suff * arr[n - i - 1] < Integer.MIN_VALUE) continue;

            pre *= arr[i];
            suff *= arr[n - i - 1];
            ans = Math.max(ans, Math.max(pre, suff));
            System.out.println(arr[i] + " : " + pre + " : " + suff + " : " + " : " + ans);
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        int[] ans = {0, 10, 10, 10, 10, 10, 10, 10, 10, 10, -10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 0};
        System.out.println(maxProduct(ans));
    }
}
