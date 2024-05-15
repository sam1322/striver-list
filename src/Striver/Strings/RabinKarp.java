package Striver.Strings;

public class RabinKarp {
    public static boolean check(int index, String A, String B) {
        for (int i = 0; i < B.length(); i++) {
            if (A.charAt((i + index) % A.length()) != B.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public final static int d = 256;

    public static boolean rabinKarp1(String txt, String pat) {
        int q = 101;
        int M = pat.length();
        int N = txt.length();
        int i, j;
        int p = 0; // hash value for pattern
        int t = 0; // hash value for txt
        int h = 1;

        // The value of h would be "pow(d, M-1)%q"
        for (i = 0; i < M - 1; i++)
            h = (h * d) % q;

        // Calculate the hash value of pattern and first
        // window of text
        for (i = 0; i < M; i++) {
            p = (d * p + pat.charAt(i)) % q;
            t = (d * t + txt.charAt(i)) % q;
        }

        // Slide the pattern over text one by one
        for (i = 0; i <= N - M; i++) {

            // Check the hash values of current window of
            // text and pattern. If the hash values match
            // then only check for characters one by one
            if (p == t) {
                /* Check for characters one by one */
                for (j = 0; j < M; j++) {
                    if (txt.charAt(i + j) != pat.charAt(j)) {
                        break;
                    }
                }

                // if p == t and pat[0...M-1] = txt[i, i+1,
                // ...i+M-1]
                if (j == M) {
                    return true;
                }
//                    System.out.println(
//                            "Pattern found at index " + i);
            }

            // Calculate hash value for next window of text:
            // Remove leading digit, add trailing digit
            if (i < N - M) {
                t = (d * (t - txt.charAt(i) * h)
                        + txt.charAt(i + M))
                        % q;

                // We might get negative value of t,
                // converting it to positive
                if (t < 0)
                    t = (t + q);
            }
        }
        return false;
    }

    public static long getVal(char c) {
        return c - 'a' + 1;
//        return c;
    }

    public static boolean rabinKarp(String text, String pattern) {
        long p = 31;
//        long p = 256;
        long pow = 1;
        long dsv = 0;
        long mod = 1000000007;
//        long mod = 101;
        int patLen = pattern.length();
        int textLen = text.length();
        long patternHash = 0;
        long textHash = 0;


        for (int i = 0; i < patLen; i++) {
            patternHash = (p * patternHash + getVal(pattern.charAt(i))) % mod;
            textHash = (p * textHash + getVal(text.charAt(i))) % mod;
            if (i != patLen - 1) {
                pow = (pow * p) % mod;
            }
        }
        for (int i = 0; i <= textLen - patLen; i++) {
            System.out.println("Pattern Hash: " + patternHash + " Text Hash: " + textHash);
            System.out.println("Pattern: " + pattern + " Text: " + text.substring(i, i + patLen));
            if (patternHash == textHash && check(i, text, pattern)) {
                return true;
            }
            if (i < textLen - patLen) {
                textHash = (p * (textHash - (getVal(text.charAt(i))) * pow) + (getVal(text.charAt(i + patLen)))) % mod;
                if (textHash < 0) {
                    textHash += mod;
                }
            }
        }

        return false;
    }

    public static int repeatedStringMatch(String a, String b) {
        int q = 1;
        String s = new String(a);
        for (; s.length() < b.length(); q++) s += a;
//        if (s.contains(b)) return q;
        if (rabinKarp(s, b)) return q;
        s += a;
        if (rabinKarp(s, b)) return q + 1;
//        if (s.contains(b)) return q + 1;
        return -1;
    }

    public static void main(String[] args) {
        String text = "abca";
        String pattern = "caabcaabca";
//        String pattern = "caab";
        System.out.println(repeatedStringMatch(text, pattern));
    }
}
