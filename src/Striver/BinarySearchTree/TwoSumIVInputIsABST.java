package Striver.BinarySearchTree;

import Striver.BinaryTree.TreeNode;
import Striver.BinaryTree.TreeNodeImpl;

import java.util.List;

public class TwoSumIVInputIsABST {
    public static boolean findTarget(TreeNode root, int k) {
        return dfs(root,root,k);

    }
    public static boolean dfs(TreeNode root, TreeNode cur,int k ){
        if(cur==null)return false;
        return search(root,cur,k - cur.val)||dfs(root,cur.left,k)||dfs(root,cur.right,k);
    }

    private static boolean search(TreeNode root,TreeNode cur, int value){
        if(root==null)return false;
        return (root.val==value && root!=cur)||(root.val<value && search(root.right,cur,value))||(root.val>value && search(root.left,cur,value));
    }
    public static void main(String[] args) {
        TreeNode root = TreeNodeImpl.insertTree(List.of(5,3,6,2,4,-1,7));
        int k = 9;
        System.out.println(findTarget(root,k));
    }
}
