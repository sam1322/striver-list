import java.util.ArrayList;
import java.util.List;

public class MinStack {
    List<Integer[]> list;

    public MinStack() {
        this.list = new ArrayList<>();

    }

    public void push(int val) {
        if (list.isEmpty()) {
            Integer[] arr = new Integer[]{val, val};
            list.add(arr);
        }
        else{
            Integer[] lastElement = list.get(list.size() - 1 );
            Integer mx = Math.min(lastElement[1],val);
            Integer[] arr = new Integer[]{val,mx};
            list.add(arr);
        }
    }

    public void pop() {
        if(list.isEmpty())return ;
        list.remove(list.size() - 1);
    }

    public int top() {
        if(list.isEmpty())return -1;
        return list.get(list.size() -1 )[0];
    }

    public int getMin() {
        if(list.isEmpty())return -1;
        return list.get(list.size() -1 )[1];
    }

}
