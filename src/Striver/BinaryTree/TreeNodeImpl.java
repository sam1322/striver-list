package Striver.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNodeImpl {
    public static int widthOfBinaryTree(TreeNode root){
        int mx = 0;
        Queue<Object[]> q = new LinkedList<>();
        q.add(new Object[]{0,root});
        while(!q.isEmpty()){
            int n = q.size();
            int min = Integer.MAX_VALUE ;
            int max = Integer.MIN_VALUE;
//            System.out.println("Hey");
            for(int i = 0 ;  i< n; ++i){
                Object[] cur = q.poll();
                int key = (int) cur[0];
                TreeNode node = (TreeNode) cur[1];

                if(i==0)
                    min = Math.min(min,key);
                if(i==n-1)
                    max = Math.max(max,key);

                if(node.left!=null){
                    q.add(new Object[]{2*key,node.left});
                }
                if(node.right !=null){
                    q.add(new Object[]{2*key + 1,node.right});
                }
//                System.out.println(key+ " : " + node.val);
            }
//            System.out.println("Max : " + max + ", Min : " + min);
            // if(max != Integer.MIN_VALUE && min !=Integer.MAX_VALUE ){
            //   if(n!=1){
            mx = Math.max(mx,max - min + 1);
            // }
        }
        return mx;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        // Creates a left child node for
        // the root with a key value of 2
        root.left = new TreeNode(2);
        // Creates a right child node for
        // the root with a key value of 3
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.left.right.left = new TreeNode(8);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        root.right.right.left = new TreeNode(9);
        root.right.right.right = new TreeNode(10);

        System.out.println(widthOfBinaryTree(root));
    }
}
