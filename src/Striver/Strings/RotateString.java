package Striver.Strings;

public class RotateString {
    public static boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;
        boolean flag = true;
        int n = s.length(), pos;
        for (int i = 0; i < n; ++i) {
            flag = true;
            for (int j = 0; j < n; ++j) {
                pos = (j + i) % n;
                if (s.charAt(j) != goal.charAt(pos)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "abcde";
//        String r = "cdeab";
        String r = "abced";
        System.out.println(rotateString(s, r));
    }
}
