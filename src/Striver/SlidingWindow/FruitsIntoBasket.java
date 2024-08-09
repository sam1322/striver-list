package Striver.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class FruitsIntoBasket {

    public static int totalFruits(Integer[] arr, int k) {
        int n = arr.length;
        int left = 0, right = 0, ans = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        while (right < n) {
            mp.put(arr[right], mp.getOrDefault(arr[right], 0) + 1);
            while (mp.size() > k) {
                mp.put(arr[left], mp.get(arr[left]) - 1);
                if (mp.get(arr[left]) == 0) {
                    mp.remove(arr[left]);
                }
                left++;
            }
            if (mp.size() <= k) {
                ans = Math.max(ans, right - left + 1);
            }
            right++;
        }
        return ans;
    }

    public static int totalFruits_Optimized(Integer[] arr, int k) {
        int n = arr.length;
        int left = 0, right = 0, ans = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        while (right < n) {
            mp.put(arr[right], mp.getOrDefault(arr[right], 0) + 1);
            if (mp.size() > k) {
                mp.put(arr[left], mp.get(arr[left]) - 1);
                if (mp.get(arr[left]) == 0) {
                    mp.remove(arr[left]);
                }
                left++;
            }
            if (mp.size() <= k) {
                ans = Math.max(ans, right - left + 1);
            }
            right++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Integer arr[] = {3, 1, 2, 2, 2, 2};
        System.out.println(totalFruits(arr, 2));
        System.out.println(totalFruits_Optimized(arr, 2));
    }
}
