package Striver.BinarySearchTree;

import Striver.BinaryTree.*;

import java.util.List;

public class LowestCommonAncestor {
    public static Node pre = null, suc = null;

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        int curr = root.val;
        if (curr < p.val && curr < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        if (curr > p.val && curr > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        return root;
    }

    public static void findPreSuc(Node root, int key) {
        if (root == null) return;
        if (root.data == key) {
            if(root.left !=null){
                Node curr = root.left;
                while(curr.right!=null){
                    curr = curr.right;
                }
                pre = curr;
            }
            if(root.right !=null){
                Node curr = root.right;
                while(curr.left!=null){
                    curr = curr.left;
                }
                suc = curr;
            }

        } else if (root.data < key) {
            pre = root;
            findPreSuc(root.right, key);
        } else if (root.data > key) {
            suc = root;
            findPreSuc(root.left, key);
        }

    }

    public static void NodeTreeImplementation() {
        Node root = NodeImpl2.insertTree(List.of(6, 2, 8, 0, 4, 7, 9, -1, -1, 3, 5));
        int key = 2;
        pre = null;
        suc = null;
        findPreSuc(root, 2);
        if (pre != null) {
            System.out.println("Predecessor is " + pre.data);
        }
        if (suc != null) {
            System.out.println("Predecessor is " + suc.data);
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeNodeImpl.insertTree(List.of(6, 2, 8, 0, 4, 7, 9, -1, -1, 3, 5));
        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(4);

        TreeNode lca = lowestCommonAncestor(root, p, q);
        System.out.println(ArrayToBST.isValidBst(root));
        BinaryTreePrinter.printTree(root);
        if (lca != null) {
            System.out.println("LCA is " + lca.val);
        } else {
            System.out.println("No LCA found");
        }
        NodeTreeImplementation();

    }
}
