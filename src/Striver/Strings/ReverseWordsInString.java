package Striver.Strings;

import java.util.Stack;

public class ReverseWordsInString {

    public static String reverseWords(String s) {
        String ans = "";
        Stack<String> st = new Stack<>();
        String str = "";
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (ch != ' ') {
                str+=ch;
            }
            else{
                if(!str.isEmpty()){
                    st.push(str);
                    str="";
                }
            }
        }
        if(!str.isEmpty()){
            st.push(str);
            str="";
        }
        while(!st.isEmpty()){
            ans +=st.pop();
            ans+=" ";
        }
        return ans.substring(0,ans.length() - 1);
    }

    public static void main(String[] args) {
     String s ="the sky is blue";
     String reverse = reverseWords(s);
        System.out.println(reverse);
    }
}
