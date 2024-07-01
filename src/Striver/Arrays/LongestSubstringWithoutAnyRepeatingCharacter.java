package Striver.Arrays;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutAnyRepeatingCharacter {
    public static int solve(String str) {
        int n = str.length();
        int left = 0, right = 0;
        Map<Character, Integer> mp = new HashMap<>();
        int ans = 0;
        while (  right < n) {
            Character ch = str.charAt(right);
            if (mp.containsKey(ch) && mp.get(ch) >= left) {
                ans = Math.max(ans, right - left);
                left = mp.get(ch) + 1;
                System.out.println("mp[" + ch + "] = " + mp.get(ch));
            }
            System.out.println(left+" : " + right + " : " + ans);
            mp.put(ch, right);
            right++;

        }
        System.out.println(left+" : " + right + " : " + ans);
        ans = Math.max(ans, right - left);
        return ans;
    }

    public static void main(String[] args) {
//        String str = "takeUforward";
        String str = "pwwkew";
        System.out.println("The length of the longest substring without repeating characters is " + solve(str));

    }
}
