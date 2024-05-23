package Striver.BinaryTree;

public class Node {
    public int data;
    public Node left;
    public Node right;
    public Node next;
//    public Node prev;
//    public int key;

    public Node(int data) {
        this.data = data;
        left = null;
        right = null;
        next = null;
    }

//    public Node(int key, int data) {
//        this.key = key;
//        this.data = data;
//        left = null;
//        right = null;
//        next = null;
//    }
}