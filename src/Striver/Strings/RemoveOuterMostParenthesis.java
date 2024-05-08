package Striver.Strings;

public class RemoveOuterMostParenthesis {
    public static String removeOuterParentheses(String s) {
        String ans = "";
        String str = "";
        int ctr = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            char ch = s.charAt(i);
            if (ch == '(') {
                ctr++;
                str += ch;
            } else {
                ctr--;
                str += ch;
                if (ctr == 0) {
                    if (str.length() > 2) {
                        String sh = str.substring(1, str.length() - 1);
//                        System.out.println("String " + sh + ", actual string" + str);
                        ans += sh;
                    }
                    str = "";
                }
            }
//            System.out.println("ans " + ans + ", str " + str + ", c " + ctr);
        }
        return ans;
    }

    public static void main(String[] args) {
//        String s = "(()())(())";
//        String s ="(()())(())(()(()))";
        String s = "()()";
        String removed = removeOuterParentheses(s);
        System.out.println("Element " + removed);
//        QuickSort.PrintArr(num);
    }
}
