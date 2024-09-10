package Striver.SlidingWindow;

public class MinimumWindowSubstring {
    public static String minWindow(String s, String t) {
            int n = s.length(), m = t.length();
            int l = 0, r = 0, cnt = 0, minLen = Integer.MAX_VALUE, sIndex = -1;
            int[] hash = new int[256];
            for (int i = 0; i < m; ++i) {
                hash[t.charAt(i)]++;
            }
            while (r < n) {
                if (hash[s.charAt(r)] > 0) cnt++;
                hash[s.charAt(r)]--;
                while (l <= r && cnt == m) {
    //                System.out.println(sIndex + ", " + l + ", " + r + ", " + minLen);

                    if (r - l + 1 < minLen) {
                        minLen = r - l + 1;
                        sIndex = l;
                    }
                    hash[s.charAt(l)]++;
                    if (hash[s.charAt(l)] > 0) cnt--;
                    l++;
    //                System.out.println(sIndex + ", " + l + ", " + r + ", " + minLen);

                }
                r++;
            }
    //        System.out.println(sIndex + ", " + l + ", " + r + ", " + minLen);
            return sIndex == -1 ? "" : s.substring(sIndex, minLen + sIndex);
    }

    public static void main(String[] args) {
        String s, t;
        s = "ADOBECODEBANC";
        t = "ABC";
        System.out.println(minWindow(s, t));
    }
}
