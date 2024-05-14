package Striver.BinaryTree;

class Node {
    // Stores the value
    // of the node
    int data;
    // Reference to the
    // left child node
    Node left;
    // Reference to the
    // right child node
    Node right;

    // Constructor to initialize
    // a node with a given key
    public Node(int key) {
        // Assigns the provided key to
        // the data field of the node
        data = key;
        // Initializes left child
        // reference as null
        left = null;
        // Initializes right child
        // reference as null
        right = null;
    }
}