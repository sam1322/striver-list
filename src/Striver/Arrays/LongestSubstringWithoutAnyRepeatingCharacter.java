package Striver.Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutAnyRepeatingCharacter {
    public static int solve(String str) {
        int n = str.length();
        int left = 0, right = 0;
        Map<Character, Integer> mp = new HashMap<>();
        int ans = 0;
        while (right < n) {
            Character ch = str.charAt(right);
            if (mp.containsKey(ch)) {
                ans = Math.max(ans, right - left);
                left = mp.get(ch) + 1;
            }
            mp.put(ch, right);
            right++;

        }
        ans = Math.max(ans, right - left);
        return ans;
    }

    public static int striver_soln(String str) {
        int n = str.length();
        int[] hash = new int[256];
        Arrays.fill(hash, -1);
        int l = 0, r = 0, maxLen = 0;
        while (r < n) {
            Character ch = str.charAt(r);
            if (hash[ch] != -1 && hash[ch] >= l) {
                l = hash[ch] + 1;
            }
            int len = r - l + 1;
            maxLen = Math.max(maxLen, len);
            hash[ch] = r;
            r++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
//        String str = "takeUforward";
        String str = "pwwkew";
        System.out.println("The length of the longest substring without repeating characters is " + solve(str) + " " + striver_soln(str));

    }
}
