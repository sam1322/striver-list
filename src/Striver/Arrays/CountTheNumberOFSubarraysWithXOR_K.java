package Striver.Arrays;

import java.util.HashMap;
import java.util.Map;

public class CountTheNumberOFSubarraysWithXOR_K {
    public static int subarraysWithXorK(int[] arr, int k) {
        int n = arr.length;
        Map<Integer, Integer> mp = new HashMap<>();
        int xr = 0, cnt = 0;
        mp.put(xr, 1); //sett
        for (int i = 0; i < n; ++i) {
            xr ^= arr[i];
            int x = xr ^ k;
            if (mp.containsKey(x)) {
                cnt+=mp.get(x);
            }
            if (mp.containsKey(xr)) {
                mp.put(xr, mp.get(xr) + 1);
            } else {
                mp.put(xr, 1);
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] a = {4, 2, 2, 6, 4};
        int k = 6;
        int ans = subarraysWithXorK(a, k);
        System.out.println("The number of subarrays with XOR k is: " + ans);
    }
}
