package Striver.Graph;

import java.util.Set;

public class GraphImpl {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex("Bob");
        graph.addVertex("Alice");
        graph.addVertex("Mark");
        graph.addVertex("Rob");
        graph.addVertex("Maria");
        graph.addEdge("Bob", "Alice");
        graph.addEdge("Bob", "Rob");
        graph.addEdge("Alice", "Mark");
        graph.addEdge("Rob", "Mark");
        graph.addEdge("Alice", "Maria");
        graph.addEdge("Rob", "Maria");
        graph.printGraph();

        Set<String> vis = graph.Dfs(graph, "Bob");
        System.out.println(vis);
        vis = graph.Bfs(graph, "Bob");
        System.out.println(vis);
    }
}
