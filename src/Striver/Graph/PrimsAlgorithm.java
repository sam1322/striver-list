package Striver.Graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PrimsAlgorithm {
    public static int primsAlgo(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
//        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.distance));
        PriorityQueue<ArrayList<Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.get(0))); // wt , node, parent

        int[] vis = new int[V];
        // {wt, node}
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(0);
        arr.add(S);
        arr.add(-1);
        pq.add(arr);
        int sum = 0;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        while (pq.size() > 0) {
            arr = pq.peek();
            int wt = arr.get(0);
            int node = arr.get(1);
            int parent = arr.get(2);
            pq.remove();

            if (vis[node] == 1) continue;
            // add it to the mst
            vis[node] = 1;
            sum += wt;
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(parent);
            temp.add(node);
            ans.add(temp);

            for (int i = 0; i < adj.get(node).size(); i++) {
                int adjNode = adj.get(node).get(i).get(0);
                int edgeWeight = adj.get(node).get(i).get(1);
                if (vis[adjNode] == 0) {
                    ArrayList<Integer> temp2 = new ArrayList<>();
                    temp2.add(edgeWeight);
                    temp2.add(adjNode);
                    temp2.add(node);
                    pq.add(temp2);
                }
            }
        }
        System.out.println(ans);
        return sum;
    }

    public static void main(String[] args) {
//        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        int V = 5, S = 0, E = 0;
        int[][] edges = {
                {0, 1, 2},
                {0, 2, 1},
                {1, 2, 1},
                {2, 3, 2},
                {2, 4, 2},
                {3, 4, 1}
        };

        for (int i = 0; i <= V; i++) {
            adj.add(new ArrayList<>());
        }
        // for undirected weighted graphs
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];

            ArrayList<Integer> temp1 = new ArrayList<>();
            temp1.add(v);
            temp1.add(wt);
            ArrayList<Integer> temp2 = new ArrayList<>();
            temp2.add(u);
            temp2.add(wt);
            adj.get(u).add(temp1);
            adj.get(v).add(temp2);

//            adj.get(edges[i][0]).add(new Pair(edges[i][2], edges[i][1]));
//            adj.get(edges[i][1]).add(new Pair(edges[i][2], edges[i][0]));
        }
        System.out.println(primsAlgo(V, adj, S));
    }
}
