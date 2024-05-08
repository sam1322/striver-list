package Striver.Strings;

public class largestOddNumberInString {
    public static String largestOddNumberInString(String s) {
        int n = s.length();
        System.out.println(n);
        for (int i = n - 1; i >= 0; i--) {
            char ch = s.charAt(i);
//            System.out.println("ch "+ ch);
            int num = ch - '0';
//            System.out.println("num "+num);
            if (num % 2 != 0) {
//                System.out.println(i);
//                System.out.println(s.substring(0,i+1));
//                System.out.println(s);
                return s.substring(0, i + 1);
            }
        }
        return "";
    }

    public static void main(String[] args) {
        String s = "2356234523";
        String str = largestOddNumberInString(s);
        System.out.println("String : " + str);
    }
}
