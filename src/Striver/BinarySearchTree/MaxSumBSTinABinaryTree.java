package Striver.BinarySearchTree;

import Striver.BinaryTree.TreeNode;
import Striver.BinaryTree.TreeNodeImpl;

import java.util.List;

public class MaxSumBSTinABinaryTree {
    private int maxSum = 0;

    public int maxSumBST(TreeNode root) {
        if (root == null) return 0;
        maxSum(root);
        return maxSum;
    }

    private int[] maxSum(TreeNode root) {
        if (root == null) {
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0}; // { min, max,sum }
        }
        int[] left = maxSum(root.left);
        int[] right = maxSum(root.right);
        if (!(left != null && right != null && left[1] < root.val && right[0] > root.val)) return null;

        int sum = left[2] + right[2] + root.val;
        maxSum = Math.max(maxSum, sum);

        int minNode = Math.min(left[0], root.val);
        int maxNode = Math.max(right[1], root.val);

        return new int[]{minNode, maxNode, sum};
    }

    public static void main(String[] args) {
        System.out.println("MaxSumBSTinABinaryTree");
        TreeNode root = TreeNodeImpl.insertTree(List.of(1, 4, 3, 2, 4, 2, 5, -1, -1, -1, -1, -1, -1, 4, 6));
        MaxSumBSTinABinaryTree obj = new MaxSumBSTinABinaryTree();
        System.out.println(obj.maxSumBST(root));
    }
}
