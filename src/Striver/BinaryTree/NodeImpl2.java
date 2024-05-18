package Striver.BinaryTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NodeImpl2 {
    public static Node insertTree(List<Integer> list) {
        Queue<Node> q = new LinkedList<>();
        if (list.isEmpty()) return null;
        Node root = new Node(list.get(0));
        q.add(root);
        int i = 1;
        int n = list.size();
        while (!q.isEmpty()) {
            Node node = q.poll();
            if (i < n) {
                if (list.get(i) != -1) {
                    node.left = new Node(list.get(i));
                    q.add(node.left);
                }

                i++;
            }
            if (i < n) {
                if (list.get(i) != -1) {
                    node.right = new Node(list.get(i));
                    q.add(node.right);
                }
                i++;
            }
        }
        return root;
    }

    private static Node connect(Node root) {
        if (root == null) return null;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int n = q.size();
            Node prev = q.poll();
            if(prev.left !=null) q.add(prev.left);
            if(prev.right !=null) q.add(prev.right);

            for (int i = 1; i < n; ++i) {
                Node curr = q.poll();
                prev.next = curr;
                prev = curr;
                if(curr.left !=null) q.add(curr.left);
                if(curr.right !=null) q.add(curr.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Node root = insertTree(List.of(1, 2, 3, 4, 5, 6, 7));
    }

}
