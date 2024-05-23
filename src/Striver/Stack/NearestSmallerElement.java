package Striver.Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NearestSmallerElement {
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> arr= new ArrayList<>();
        for(int i =0 ; i < A.size(); ++i){
            while(!st.isEmpty() && st.peek() >= A.get(i)){
                st.pop();
            }
            if(st.isEmpty()){
                arr.add(-1);
            }else{
              arr.add(st.peek());
            }
            st.push(A.get(i));
        }
        return arr;
    }

    public static void main(String[] args) {
    }
}
