package Striver.BinaryTree;

public class SymetricTree {
    private static boolean checkSymmetry(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;

        return p.val == q.val && checkSymmetry(p.left, q.right) && checkSymmetry(p.right, q.left);
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return checkSymmetry(root.left, root.right);
    }
}
