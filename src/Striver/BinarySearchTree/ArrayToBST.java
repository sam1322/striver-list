package Striver.BinarySearchTree;

import Striver.BinaryTree.TreeNode;

public class ArrayToBST {
    private static TreeNode BST_DFS(int[] nums, int low, int high) {
        if (low > high) return null;
        int mid = low + (high - low) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = BST_DFS(nums, low, mid - 1);
        root.right = BST_DFS(nums, mid + 1, high);
        return root;
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return BST_DFS(nums, 0, nums.length - 1);
    }

    public static TreeNode bstFromPreorder(int[] nums, int low, int high) {
        if (low > high) return null;
        TreeNode root = new TreeNode(nums[low]);
        int mid = low + 1;
        for (; mid <= high; ++mid) {
            if (nums[mid] > root.val) {
                break;
            }
        }
        root.left = bstFromPreorder(nums, low + 1, mid - 1);
        root.right = bstFromPreorder(nums, mid, high);
        return root;
    }

    public static TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder, 0, preorder.length - 1);
    }

    public static boolean isValidBst(TreeNode root) {
        if (root == null) return true;

        TreeNode maxNode = root.left;
        if (maxNode != null) {
            while (maxNode.right != null) {
                maxNode = maxNode.right;
            }
            if (maxNode.val >= root.val) return false;
        }


        TreeNode minNode = root.right;
        if (minNode != null) {
            while (minNode.left != null) {
                minNode = minNode.left;
            }
            if (minNode.val <= root.val) return false;
        }

        boolean leftBool = isValidBst(root.left);
        if (!leftBool) return false;
        return isValidBst(root.right);
    }
}
