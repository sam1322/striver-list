package Striver.Greedy;

import java.util.Arrays;

public class MinimumNoOfPlatformsRequired {
    public static int minimumPlatforms(int[] arr, int[] dep) {
        int result = 0;
        int platforms = 0;
        Arrays.sort(arr);
        Arrays.sort(dep);
        int n = dep.length;
        int i = 0, j = 0;
        while (i < n && j < n) {
            if (arr[i] <= dep[j]) {
                i++;
                platforms++;
            } else if (arr[i] > dep[j]) {
                platforms--;
                j++;
            }
            result = Math.max(platforms, result);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {900, 940, 950, 1100, 1500, 1800};
        int[] dep = {910, 1200, 1120, 1130, 1900, 2000};

        System.out.println(minimumPlatforms(arr, dep));
    }
}
