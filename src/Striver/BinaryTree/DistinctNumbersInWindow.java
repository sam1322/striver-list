package Striver.BinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DistinctNumbersInWindow {
    public static int[] dNums(int[] arr, int k) {
        int n = arr.length;
        Map<Integer, Integer> mp = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int start = 0, end = 0, count = 0;
        for (int i = 0; i < n; ++i) {
            end++;
            int freq = mp.getOrDefault(arr[i], 0);
            if (freq == 0) count++;
            mp.put(arr[i], freq + 1);
            while (end - start > k) {
                int value = mp.get(arr[start]);
                mp.put(arr[start], value - 1);
                if (value == 1) count--;
                start++;
            }
            if (end - start == k) {
                int cnt = 0;
                // for (Integer key : mp.keySet()) {
                //     if (mp.get(key) > 0) {
                //         cnt++;
                //     }
                // }
                list.add(count);

            }

        }
        int[] arrList = new int[list.size()];
        int index = 0;
        for (Integer j : list) arrList[index++] = j;
        System.out.println(list);
        return arrList;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 1, 3, 4, 3
        };
        int k = 3;
        dNums(arr, k);
        arr = new int[]{1, 1, 2, 2};
        k = 1;
        dNums(arr, k);

    }
}
