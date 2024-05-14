package Striver.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class CloneGraph {
    public Node dfs(Node root, Map<Node, Node> visited) {
        if (root == null) return root;

        if (visited.containsKey(root)) {
            return visited.get(root);
        }

        Node newRoot = new Node(root.val);
        visited.put(root, newRoot);

        // if (root.neighbors == null || root.neighbors.isEmpty()) return newRoot;


        for (Node child : root.neighbors) {
            Node newChild = dfs(child, visited);
            newRoot.neighbors.add(newChild);
        }
        return newRoot;
    }

    public Node cloneGraph(Node node) {
        Map<Node, Node> visited = new HashMap<>();
        return dfs(node, visited);
    }
}
