package Striver.Graph;

import java.util.*;

public class DijkstraShortestPath {
    public static List<Integer> dijkstraShortestPath(int V, ArrayList<ArrayList<Pair>> adj, int S, int E) {
        // Write your code here
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);
        List<Integer> path = new ArrayList<>();
        if(S==E){
            path.add(-1);
            return path;
        }

        int[] dist = new int[V];
        int[] parent = new int[V] ;

        int maxVal = (int) (1e9);

        Arrays.fill(dist, maxVal);
        Arrays.fill(parent,-1);

        dist[S] = 0;
        pq.add(new Pair(0, S));

        while (!pq.isEmpty()) {
            int distance = pq.peek().distance;
            int node = pq.peek().node;
            pq.remove();
            for(Pair pair : adj.get(node)){
                int edgeWeight = pair.distance;
                int adjNode = pair.node;
//                System.out.println(node + " : " + adjNode + " : " + edgeWeight);
                if(distance + edgeWeight < dist[adjNode]){
                    dist[adjNode] = distance + edgeWeight;
                    parent[adjNode] = node;
                    pq.add(new Pair(dist[adjNode],adjNode));
                }
            }
        }
        if(dist[E] ==maxVal){
            path.add(-1);
            return path;
        }
        int p = E;
        while(p!=-1){
            path.add(p);
            p = parent[p];
        }
        Collections.reverse(path);
        return path;
    }


    public static void main(String[] args) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        int V = 3, S = 2 , E = 0;
        int[][] edges = {
                {0, 1, 1},
                {1, 2, 3},
                {2, 0, 6},
        };

        for (int i = 0; i <= V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
//            adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
//            adj.get(edges[i][1]).add(new Pair(edges[i][0], edges[i][2]));
            adj.get(edges[i][0]).add(new Pair(edges[i][2], edges[i][1]));
            adj.get(edges[i][1]).add(new Pair(edges[i][2], edges[i][0]));
        }
        System.out.println(dijkstraShortestPath(V,adj,S,E));
    }
}
