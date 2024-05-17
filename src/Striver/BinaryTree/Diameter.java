package Striver.BinaryTree;

public class Diameter {
    private static int diameter = 0;
    private static boolean isBalanced = true;
    private static int sum = 0;

    private static int calcHeight(Node root) {
        if (root == null) return 0;
        int lh = calcHeight(root.left);
        int rh = calcHeight(root.right);
        diameter = Math.max(diameter, lh + rh);
        return 1 + Math.max(lh, rh);
    }

    public static int diameterOfTree(Node root) {
        diameter = 0;
        calcHeight(root);
        return diameter;
    }


    private static int checkHeight(Node root) {
        if (root == null) return 0;
        int lh = checkHeight(root.left);
        int rh = checkHeight(root.right);
//        diameter =  Math.max(diameter, lh + rh);
        if (Math.abs(lh - rh) > 1) {
            isBalanced = false;
        }
        return 1 + Math.max(lh, rh);
    }

    public static boolean checkBalanced(Node root) {
        isBalanced = true;
        checkHeight(root);
        return isBalanced;
    }

    public static Node lowestCommonAncestor(Node root, Node p, Node q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        Node left = lowestCommonAncestor(root.left, p, q);
        Node right = lowestCommonAncestor(root.right, p, q);

        //result
        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else { //both left and right are not null, we found our result
            return root;
        }
    }

    public static int maxSum(Node node) {
        sum = Integer.MIN_VALUE;
        calcSum(node);
        return sum;
    }

    public static int calcSum(Node node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) {
            sum = Math.max(sum, node.data);
            return node.data;
        }

        int leftSum = Math.max(0,calcSum(node.left));
        int rightSum = Math.max(0,calcSum(node.right));

        sum = Math.max(sum, leftSum + node.data + rightSum);
        return  Math.max(leftSum, rightSum) + node.data;
    }
}
