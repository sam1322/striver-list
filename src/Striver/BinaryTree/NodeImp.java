package Striver.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NodeImp {
    public static void inorder(Node root) {
        if (root == null) return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);

    }

    public static void preorder(Node root) {
        if (root == null) return;


        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void postOrder(Node root) {
        if (root == null) return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    public static  List<Integer> morrisInorder(Node root){
        List<Integer> inorderList = new ArrayList<>();
        Node cur = root;
        while(cur!=null){
            if(cur.left == null){
                inorderList.add(cur.data);
                cur = cur.right;
            }
            else{
                Node prev = cur.left ;
                while(prev.right != null && prev.right != cur){
                    prev=prev.right;
                }
                if(prev.right == null){
                    prev.right = cur;
                    cur = cur.left;
                }
                else{
                    prev.right = null;
                    inorderList.add(cur.data);
                    cur = cur.right;
                }
            }
        }
        return inorderList;
    }

    public static void levelOrder(Node root) {
        if (root == null) return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node curr = q.poll();
            System.out.print(curr.data + " ");
            if (curr.left != null) {
                q.add(curr.left);
            }
            if (curr.right != null) {
                q.add(curr.right);
            }
        }
    }

    public static void PrintList(List<Integer> list ){
        for(Integer i : list){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Creates the root node
        // with a key value of 1
        Node root = new Node(1);
        // Creates a left child node for
        // the root with a key value of 2
        root.left = new Node(2);
        // Creates a right child node for
        // the root with a key value of 3
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.left.right.left = new Node(8);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        root.right.right.left = new Node(9);
        root.right.right.right = new Node(10);

        System.out.print("Inorder   : ");
        inorder(root);
        System.out.println();

        System.out.print("Preorder  : ");
        preorder(root);
        System.out.println();

        System.out.print("Postorder : ");
        postOrder(root);
        System.out.println();

        System.out.print("LevelOrder: ");
        levelOrder(root);
        System.out.println();

        System.out.print("MorInorder: ");
        List<Integer> list = morrisInorder(root);
        PrintList(list);
    }
}

