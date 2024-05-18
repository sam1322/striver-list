package Striver.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePrinter {

    private static final String PREFIX = "├── ";
    private static final String CHILD_PREFIX = "│   ";
    private static final String EMPTY_PREFIX = "    ";
    private static final String LEFT_CHILD_PREFIX = "L:";
    private static final String RIGHT_CHILD_PREFIX = "R:";

    public static void printTree(TreeNode root) {
        List<String> lines = new ArrayList<>();
        buildTreeLines(root, "", lines, true, null);

        for (String line : lines) {
            System.out.println(line);
        }
    }

    private static void buildTreeLines(TreeNode node, String prefix, List<String> lines, boolean isLastChild, TreeNode parent) {
        if (node == null) {
            return;
        }

        String childPrefix = isLastChild ? EMPTY_PREFIX : CHILD_PREFIX;
        String nodePrefix = prefix + (isLastChild ? "└── " : PREFIX);

        if (parent == null) {
            lines.add(nodePrefix + node.val);
        } else if (parent.left == node) {
            lines.add(nodePrefix + LEFT_CHILD_PREFIX + node.val);
        } else {
            lines.add(nodePrefix + RIGHT_CHILD_PREFIX + node.val);
        }

        buildTreeLines(node.left, prefix + childPrefix, lines, false, node);
        buildTreeLines(node.right, prefix + childPrefix, lines, true, node);
    }

//    public static void main(String[] args) {
//        TreeNode root = new TreeNode('z',
//                new TreeNode('c',
//                        new TreeNode('a'),
//                        new TreeNode('b')),
//                new TreeNode('d'),
//                new TreeNode('e',
//                        new TreeNode('a', null, new TreeNode('s', null, new TreeNode('d', null, new TreeNode('f')))),
//                        null),
//                new TreeNode('f'));
//
//        printTree(root);
//    }



    public static void printTreePattern(TreeNode root) {
        printTreePatternHelper(root, "", true);
    }


    private static void printTreePatternHelper(TreeNode node, String indent, boolean isRight) {
        if (node == null) {
            return;
        }

        System.out.print(indent);
        if (isRight) {
            System.out.print("R:");
            indent += "   ";
        } else {
            System.out.print("L:");
            indent += "|  ";
        }
        System.out.println(node.val);

        printTreePatternHelper(node.left, indent, false);
        printTreePatternHelper(node.right, indent, true);
    }
}
