package Striver.Recursions;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    public static boolean checkPalindrome(String str) {
        for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
            if (str.charAt(i) != str.charAt(j)) return false;

        }
        return true;
    }

    public static void partition(int index, List<String> cur, String s, List<List<String>> list) {
        if (index >= s.length()) {
            list.add(new ArrayList<>(cur));
            return;
        }
        String str = "";
        for (int i = index ; i < s.length(); i++) {
            str += s.charAt(i);
            if (checkPalindrome(str)) {
                cur.add(str);
                partition(i + 1,cur,s,list);
                cur.remove(cur.size() - 1);
            }
        }
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> palindromeList = new ArrayList<>();
        List<String> arr = new ArrayList<>();
        partition(0, arr, s,palindromeList);
        return palindromeList;
    }

    public static void main(String[] args) {
        String s ="aabac";
        List<List<String>> list = partition(s);
        System.out.println(list);
    }
}
