package Striver.Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class OnlineStockSpan {
    private Stack<Integer> stack;
    private List<Integer> list;

    public OnlineStockSpan() {
        stack = new Stack<>();
        list = new ArrayList<>();
    }

    public int next(int price) {
        while (!stack.isEmpty() && list.get(stack.peek()) <= price) {
            stack.pop();
        }
        int ans = stack.isEmpty() ? list.size() + 1 : list.size() - stack.peek() ;
        stack.push(list.size());
        list.add(price);
        return ans;
    }

    public static void main(String[] args) {
        OnlineStockSpan stockSpanner = new OnlineStockSpan();
        System.out.println(stockSpanner.next(100)); // return 1
        System.out.println(stockSpanner.next(80));  // return 1
        System.out.println(stockSpanner.next(60));  // return 1
        System.out.println(stockSpanner.next(70));  // return 2
        System.out.println(stockSpanner.next(60));  // return 1
        System.out.println(stockSpanner.next(75));  // return 4, because the last 4 prices (including today's price of 75) were less than or equal to today's price.
        System.out.println(stockSpanner.next(85));  // return 6
    }
}
