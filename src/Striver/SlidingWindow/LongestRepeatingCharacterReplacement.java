package Striver.SlidingWindow;

public class LongestRepeatingCharacterReplacement {
    public static int characterReplacement(String s, int k) {
        int maxLen = 0;
        int n = s.length();
        int[] hash = new int[256];
        int maxFreq = 0;
        int l = 0, r = 0;
        while (r < n) {
            char ch = s.charAt(r);
            hash[ch]++;
            maxFreq = Math.max(maxFreq, hash[ch]);
            if ((r - l + 1) - maxFreq > k) {
                char c = s.charAt(l);
                hash[c]--;
                maxFreq = 0;
//                for (int i = 0; i < hash.length; ++i) maxFreq = Math.max(maxFreq, hash[i]);
                l++;
            }
            if ((r - l + 1) - maxFreq <= k) {
                maxLen = Math.max(maxLen, (r - l + 1));
            }
            r++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "ABAB";
        int k = 2;
        System.out.println(characterReplacement(s, k));
        s = "AABABBA";
        k = 1;
        System.out.println(characterReplacement(s, k));
    }
}
