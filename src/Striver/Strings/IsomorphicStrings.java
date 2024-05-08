package Striver.Strings;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        int n = s.length();
        Map<Character, Character> mp = new HashMap<>();
        Map<Character, Character> map = new HashMap<>();

        for (int i = 0; i < n; ++i) {
            Character ch = s.charAt(i);
            Character ct = t.charAt(i);
            Boolean m = mp.containsKey(ch);
            Boolean j = map.containsKey(ct);
            if (!m && !j) {
                mp.put(ch, ct);
                map.put(ct, ch);
            } else if (m && j) {
                if (mp.get(ch) != ct) {
                    return false;
                }
            } else return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "baba";
        String t = "badc";
        System.out.println("Isomorphic String ? " + s + " : " + t + " = " + isIsomorphic(s, t));
    }
}
