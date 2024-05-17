package Striver.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class BoundaryTraversal {
    private static boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
    }

    private static void addLeftBoundary(Node node, List<Integer> ans) {
        Node curr = node.left;
        while(curr!=null){
            if(!isLeaf(curr)){
                ans.add(curr.data);
            }
            if(curr.left !=null){
                curr = curr.left;
            }
            else{
                curr = curr.right;
            }
        }
    }


    private static void addLeaves(Node node, List<Integer> ans) {
        if (isLeaf(node)) {
            ans.add(node.data);
            return;
        }
        if (node.left != null) {
            addLeaves(node.left, ans);
        }
        if (node.right != null) {
            addLeaves(node.right, ans);
        }
    }

    private static void addRightBoundary(Node node, List<Integer> ans) {
        Node curr = node.left;
        List<Integer> temp = new ArrayList<>();
        while(curr!=null){
            if(!isLeaf(curr)){
                temp.add(curr.data);
            }
            if(curr.left !=null){
                curr = curr.left;
            }
            else{
                curr = curr.right;
            }
        }
        for(int i = temp.size() - 1 ; i >= 0 ; --i)ans.add(temp.get(i));
    }

    public static ArrayList<Integer> printBoundary(Node node) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (!isLeaf(node)) ans.add(node.data);
        addLeftBoundary(node, ans);
        addLeaves(node, ans);
        addRightBoundary(node, ans);
        return ans;
    }
}
