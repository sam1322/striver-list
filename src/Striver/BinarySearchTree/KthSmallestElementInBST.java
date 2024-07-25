package Striver.BinarySearchTree;


import Striver.BinaryTree.TreeNode;
import Striver.BinaryTree.TreeNodeImpl;

import java.util.List;

public class KthSmallestElementInBST {

    private static TreeNode inorder(TreeNode root, int[] cnt, int k) {
        if (root == null) return null;
        TreeNode left = inorder(root.left, cnt, k);
        if (left != null) return left;
        cnt[0]++;
        if (cnt[0] == k) return root;
        return inorder(root.right, cnt, k);
    }

    public static int kthSmallest(TreeNode root, int k) {
        int[] cnt = new int[1];
        TreeNode temp = inorder(root, cnt, k);
        if (temp == null) return -1;
        return temp.val;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNodeImpl.insertTree(List.of(1, 2, 5, 3, 4, -1, 6));
        int k = 3;
        System.out.println(kthSmallest(root, k));
    }
}
