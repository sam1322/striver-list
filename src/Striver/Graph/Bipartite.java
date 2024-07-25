package Striver.Graph;

import java.util.*;

public class Bipartite {
    public static boolean dfs(int node, int col, int[] color, List<List<Integer>> adj) {
        color[node] = col;
        for (int it : adj.get(node)) {
            if (color[it] == -1) {
                if (dfs(it, 1 - col, color, adj) == false) return false;
            } else if (color[it] == col) {
                return false;
            }
        }
        return true;

    }

    public static boolean bfs(int node, int col, int[] color, List<List<Integer>> adj) {
        color[node] = col;
        Queue<Integer> q = new LinkedList<>();
        q.add(node);

        int curCol = col, prevCol = col;
        col  =  1 - col ;
        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; ++i) {
                int curNode = q.poll();
                for (int it : adj.get(curNode)) {
                    if (color[it] == -1) {
                        color[it] = col;
                        q.add(it);
                    } else if (color[it] == prevCol) {
                        return false;
                    }
                }
            }
            prevCol = col;
            col = 1 - col;

        }
        return true;

    }

    public static boolean isBipartite(int V, List<List<Integer>> adj) {
        int[] color = new int[V];
        Arrays.fill(color, -1);
        for (int i = 0; i < V; ++i) {
            if (color[i] == -1) {
                if (bfs(i, 0, color, adj) == false) {
                    return false;
                }
            }
        }
        return true;

    }

    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();
        int V = 4, E = 4;
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
//        adj.get(0).add(2);
//        adj.get(2).add(0);
//        adj.get(0).add(3);
//        adj.get(3).add(0);
//        adj.get(1).add(3);
//        adj.get(3).add(1);
//        adj.get(2).add(3);
//        adj.get(3).add(2);
//        System.out.println(isBipartite(V, adj));
        int[][] edges = {{0,1}, {0,2},{0,3},{1,2},{2,3}};
        for(int i = 0 ; i < edges.length; ++i){
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        System.out.println(isBipartite(V, adj));

    }
}
