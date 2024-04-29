import java.util.Scanner;
import java.util.Stack;

public class Stacks {
    public static boolean isValid(String s) {
        boolean flag = true;
        String str = "";
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                str += ch;
            } else if (str.length() > 0) {
                char last = str.charAt(str.length() - 1);
                if ((ch == ')' && last == '(') || (ch == ']' && last == '[') || (ch == '}' && last == '{')) {
                    str = str.substring(0, str.length() - 1);
                } else {
                    System.out.println("1" + " " + ch + " " + last);
                    return false;
                }

            } else {
                System.out.println("2");
                return false;
            }
        }
        return str.isEmpty();
    }

    public static int evalPRN(String[] tokens) {
        int ans = 0;
        Stack<String> stack = new Stack<>();

        for (String str : tokens) {
            if (str == "+" || str == "-" || str.equals("*") || str.equals("/")) {
                Integer a = Integer.valueOf(stack.pop());
                Integer b = Integer.valueOf(stack.pop());

                Integer c = 0;

                if (str == "+") {
                    c = a + b;
                } else if (str.equals("-")) {
                    c = b - a;
                } else if (str.equals("*")) {
                    c = a * b;
                } else {
                    c = b/a;
                }
                String ch = String.valueOf(c);
                stack.push(ch);
            } else {
                stack.push(str);
            }
        }
        return Integer.valueOf(stack.pop());
    }

    public  static void codeChef(){
        System.out.println("Code chef");
    }

    public static void main(String[] args) {
//        String s ="()[]{}";
//        System.out.println(isValid(s));
//
//        MinStack stack = new MinStack();
//        stack.push(-2);
//        stack.push(0);
//        stack.push(-3);
//        System.out.println(stack.getMin());
//        stack.pop();
//        System.out.println(stack.top());
//        System.out.println(stack.getMin());
//        String[] str = new String[]{"2","1","+","3","*"};
//        str = new String[]{"4","13","5","/","+"};
//
//        System.out.println(evalPRN(str));
        codeChef();
        Scanner scanner = new Scanner(System.in);

        int numTestCases = scanner.nextInt(); // Read the number of test cases

        for(int i = 0 ; i < numTestCases ;++i){
            int len = scanner.nextInt(); ;
            int[] array = new int[len];
            for (int j = 0; j < len; j++) {
                array[j] = scanner.nextInt(); // Read the elements of the array
            }

            System.out.print("Test case " + (i + 1) + ": ");
            for (int element : array) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
