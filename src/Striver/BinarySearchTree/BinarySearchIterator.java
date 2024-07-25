package Striver.BinarySearchTree;

import Striver.BinaryTree.TreeNode;
import Striver.BinaryTree.TreeNodeImpl;

import java.util.List;
import java.util.Stack;

class BSTIterator {
    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        pushAll(root);
    }

    public int next() {
        TreeNode node = stack.pop();
        pushAll(node.right);
        return node.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void pushAll(TreeNode root) {
        for (; root != null; root = root.left) {
            stack.push(root);
        }
    }
}


public class BinarySearchIterator {
    public static void main(String[] args) {
        TreeNode root = TreeNodeImpl.insertTree(List.of(5, 3, 6, 2, 4, -1, 7));
        BSTIterator iterator = new BSTIterator(root);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}
