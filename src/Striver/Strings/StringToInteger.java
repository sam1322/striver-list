package Striver.Strings;

import java.util.Scanner;

public class StringToInteger {
    public static int myAtoi(String s) {
        long ans = 0;
        s = s.trim();
        boolean minus = false;
        for (int i = 0; i < s.length(); ++i) {
            Character ch = s.charAt(i);
            if (ch == '-' && i == 0) {
                minus = true;
            }
            else  if (ch == '+' && i == 0) {
                minus = false;
            }
            else if (Character.isDigit(ch)) {
                ans = ans * 10 + (ch - '0');
            } else {
                break;
            }
            if(minus && -ans < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            if(!minus && ans > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        }
        if (minus) ans = -ans;
        if(ans > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if(ans < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int) ans;
    }

    public static void main(String[] args) {
        String s;
        Scanner scanner = new Scanner(System.in);
        s = scanner.nextLine();
        System.out.println(myAtoi(s));
    }
}
