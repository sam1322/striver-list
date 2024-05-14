package Striver.Stack;

import java.util.Stack;

public class ValidParenthesis {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); ++i) {
            Character ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if (!stack.isEmpty()) {
                Character c = stack.peek();
                if ((ch == '}' && c == '{') || (ch == ']' && c == '[') || (ch == ')' && c == '(')) stack.pop();
                else return false;
            } else {
                return false;
            }

        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String[] testCases = {"()", "()[]{}", "(]"};
        for (String s : testCases) {
            System.out.println(s + " is valid ? " + isValid(s));
        }

    }
}
