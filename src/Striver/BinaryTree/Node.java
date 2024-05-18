package Striver.BinaryTree;

public class Node {
    public int data;
    public Node left;
    public Node right;
    public Node next;

    public Node(int key) {
        data = key;
        left = null;
        right = null;
        next = null;
    }
}