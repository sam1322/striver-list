package Striver.Strings;

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] s) {
        String ans = "";
        int minLen = s[0].length();
        for (String i : s) {
            minLen = Math.min(minLen, i.length());
        }

        for (int i = 0; i < minLen; ++i) {
            char ch = s[0].charAt(i);
            for(int j  = 0 ;j < s.length;++j){
                if(ch != s[j].charAt(i)){
                    return ans;
                }
            }
            ans+=ch;
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] str = {"flower", "flow", "flight"};
        String s = longestCommonPrefix(str);
        System.out.println("String " + s);
    }
}
