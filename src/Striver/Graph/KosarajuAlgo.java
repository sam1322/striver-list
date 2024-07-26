package Striver.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class KosarajuAlgo {
    private static void dfs(int node, boolean vis[], List<List<Integer>> adj, Stack<Integer> st) {
        vis[node] = true;
        for (int it : adj.get(node)) {
            if (!vis[it]) {
                dfs(it, vis, adj, st);
            }
        }
        st.push(node);
    }

    private static void dfs3(int node, boolean vis[], List<List<Integer>> adj) {
        vis[node] = true;
        for (int it : adj.get(node)) {
            if (!vis[it]) {
                dfs3(it, vis, adj);
            }
        }
    }

    public static int kosaraju(int n, List<List<Integer>> adj) {
        boolean[] vis = new boolean[n];
        Stack<Integer> st = new Stack<>();
        // sorting the nodes based on their finishing time
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(i, vis, adj, st);
            }
        }

        //now we need to transpose the graph or adjacency list
        List<List<Integer>> adjT = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            vis[i] = false;
            adjT.add(new ArrayList<>());

        }
        for (int i = 0; i < n; ++i) {
            for (Integer it : adj.get(i)) {
                // i -> it
                // it -> i
                adjT.get(it).add(i);
            }
        }

        // now we just need to count the number of dfs traversal it takes to traverse the whole graph
        int cnt = 0;
        while (!st.isEmpty()) {
            int node = st.peek();
//            System.out.println(node);
            st.pop();
            if (!vis[node]) {
                dfs3(node, vis, adjT);
                cnt++;
            }
        }

        return cnt;

    }

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {
                {1, 0}, {0, 2},
                {2, 1}, {0, 3},
                {3, 4}
        };
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < n; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
        }
        int ans = kosaraju(n, adj);
        System.out.println("The number of strongly connected components is: " + ans);

    }
}
