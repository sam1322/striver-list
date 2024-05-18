package Striver.BinarySearchTree;

import Striver.BinaryTree.BinaryTreePrinter;
import Striver.BinaryTree.TreeNode;
import Striver.BinaryTree.TreeNodeImpl;

import java.util.List;

public class BSTimpl {
    public static TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) return root;
        if (root.val < val) {
            return searchBST(root.right, val);
        } else {
            return searchBST(root.left, val);
        }
    }



    public static void main(String[] args) {
        TreeNode root = TreeNodeImpl.insertTree(List.of(4, 2, 7, 1, 3));
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode node = searchBST(root, 2);
        TreeNode root2 = ArrayToBST.sortedArrayToBST(nums);
        BinaryTreePrinter.printTreePattern(root2);

        System.out.println("Preorder To BST");
        int[] nums2 = {8,5,1,7,10,12};
        TreeNode root3 = ArrayToBST.bstFromPreorder(nums2);

        BinaryTreePrinter.printTree(root3);
        System.out.println(ArrayToBST.isValidBst(root3));

        TreeNode root4 = TreeNodeImpl.insertTree(List.of(2,2,2));
        BinaryTreePrinter.printTree(root4);
        System.out.println(ArrayToBST.isValidBst(root4));

        if (node != null) {
            System.out.println("Node found " + node.val);
        } else {
            System.out.println("Node not found");
        }
    }
}
