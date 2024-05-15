package Striver.Strings;

public class LongestPalindromicSubstring {
    public static String longestPalindromicSubstring(String s) {
        String mx = "";
        int n = s.length(), low, high;
        for (int i = 0; i < n; ++i) {
            low = i - 1;
            high = i + 1;
            while (low >= 0 && high < n && s.charAt(low) == s.charAt(high)) {
                low--;
                high++;
            }
            if (high - low - 1 > mx.length()) {
                mx = s.substring(low + 1, high);
            }
            low = i  ;
            high = i + 1;
            while (low >= 0 && high < n && s.charAt(low) == s.charAt(high)) {
                low--;
                high++;
            }
            if (high - low - 1 > mx.length()) {
                mx = s.substring(low + 1, high);
            }
        }
        return mx;
    }

    public static void main(String[] args) {
        String s = "babadi";
        System.out.println(longestPalindromicSubstring(s));
    }
}
