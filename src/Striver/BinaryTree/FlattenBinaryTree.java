package Striver.BinaryTree;

public class FlattenBinaryTree {
    private static TreeNode prev = null;

    public static void flattenTree(TreeNode root){
        if (root == null) return;
        flattenTree(root.right);
        flattenTree(root.left);

        root.right = prev;
        root.left = null;
        prev = root;
    }

    public static void  flatten(TreeNode root) {
        prev = null;
        flattenTree(root);
    }
}
