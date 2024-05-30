package Striver.BinaryTree;

public class CheckSum {
    private static int flag = 1;

    private static int checkSum(Node root){
        if(root == null)return  0;

        int leftSum = checkSum(root.left);
        int rightSum = checkSum(root.right);

        if(root.data!=leftSum + rightSum){
            flag = 0;
        }
        return leftSum + rightSum + root.data;
    }

    public static int isSumProperty(Node root)
    {
        // add your code here
        flag = 1;

        checkSum(root);

        return flag;

    }

    public static void  binaryTreeToChildrenSumTree(TreeNode root){
        if (root == null) {
            return;
        }

        // Calculate the sum of the values of
        // the left and right children, if they exist.
        int child = 0;
        if (root.left != null) {
            child += root.left.val;
        }
        if (root.right != null) {
            child += root.right.val;
        }

        // Compare the sum of children with
        // the current node's value and update
        if (child >= root.val) {
            root.val = child;
        } else {
            // If the sum is smaller, update the
            // child with the current node's value.
            if (root.left != null) {
                root.left.val = root.val;
            } else if (root.right != null) {
                root.right.val = root.val;
            }
        }

        // Recursively call the function
        // on the left and right children.
        binaryTreeToChildrenSumTree(root.left);
        binaryTreeToChildrenSumTree(root.right);

        // Calculate the total sum of the
        // values of the left and right
        // children, if they exist.
        int tot = 0;
        if (root.left != null) {
            tot += root.left.val;
        }
        if (root.right != null) {
            tot += root.right.val;
        }

        // If either left or right child
        // exists, update the current node's
        // value with the total sum.
        if (root.left != null || root.right != null) {
            root.val = tot;
        }
    }
}
