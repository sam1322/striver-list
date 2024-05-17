package Striver.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class MorrisTraversal {
    public static List<Integer> morrisInorder(Node root){
        List<Integer> inorderList = new ArrayList<>();
        Node cur = root;
        while(cur!=null){
            if(cur.left == null){
                inorderList.add(cur.data);
                cur = cur.right;
            }
            else{
                Node prev = cur.left ;
                while(prev.right != null && prev.right != cur){
                    prev=prev.right;
                }
                if(prev.right == null){
                    prev.right = cur;
                    cur = cur.left;
                }
                else{
                    prev.right = null;
                    inorderList.add(cur.data);
                    cur = cur.right;
                }
            }
        }
        return inorderList;
    }
    public static List<Integer> morrisPreorder(Node root){
        List<Integer> preorderList = new ArrayList<>();
        Node cur = root;
        while(cur!=null){
            if(cur.left == null){
                preorderList.add(cur.data);
                cur = cur.right;
            }
            else{
                Node prev = cur.left ;
                while(prev.right != null && prev.right != cur){
                    prev=prev.right;
                }
                if(prev.right == null){
                    prev.right = cur;
                    preorderList.add(cur.data);
                    cur = cur.left;
                }
                else{
                    prev.right = null;
                    cur = cur.right;
                }
            }
        }
        return preorderList;
    }

}
