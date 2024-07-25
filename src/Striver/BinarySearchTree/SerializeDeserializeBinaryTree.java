package Striver.BinarySearchTree;

import Striver.BinaryTree.BinaryTreePrinter;
import Striver.BinaryTree.TreeNode;
import Striver.BinaryTree.TreeNodeImpl;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SerializeDeserializeBinaryTree {
    public static String serialize(TreeNode root) {
        String str = "";
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                str += "null,";
                continue;
            }
            str += node.val + ",";
            q.add(node.left);
            q.add(node.right);
        }
        return str;
    }

    public static TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        if (arr[0].equals("null")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int i = 1;
        int n = arr.length;
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            if (i < n && !arr[i].equals("null")) {
                cur.left = new TreeNode(Integer.parseInt(arr[i]));
                q.add(cur.left);
            }
            i++;
            if (i < n && !arr[i].equals("null")) {
                cur.right = new TreeNode(Integer.parseInt(arr[i]));
                q.add(cur.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) {
        System.out.println("SerializeDeserializeBinaryTree");
        TreeNode root = TreeNodeImpl.insertTree(List.of(1, 4, 3, 2, 4, 2, 5, -1, -1, -1, -1, -1, -1, 4, 6));
        String serialized = serialize(root);
        TreeNode root1 = deserialize(serialized);
        BinaryTreePrinter.printTree(root);
        BinaryTreePrinter.printTree(root1);
    }
}
