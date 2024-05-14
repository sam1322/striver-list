package Striver.Stack;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    Queue<Integer> q1, q2;

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int x) {

        // Push x first in empty q2
        q2.add(x);

        // Push all the remaining
        // elements in q1 to q2.
        while (!q1.isEmpty()) {
            q2.add(q1.peek());
            q1.remove();
        }

        // swap the names of two queues
        Queue<Integer> tempQ = q1;
        q1 = q2;
        q2 = tempQ;
    }

    public int pop() {
        // if no elements are there in q1
        if (q1.isEmpty())
            return Integer.MIN_VALUE;
        return q1.remove();
    }

    public int top() {
        if (q1.isEmpty())
            return Integer.MIN_VALUE;
        return q1.peek();
    }

    public boolean empty() {
        return q1.isEmpty();
    }
}
