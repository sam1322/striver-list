package Striver.Graph;

import java.util.ArrayList;
import java.util.Arrays;

public class Bellmanford {
    public static int[] bellmanFord(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        int[] dist = new int[V];
        int maxVal = (int) 1e9;
        Arrays.fill(dist, maxVal);

        dist[S] = 0;
        boolean flag = false;
        int cnt = 0;
        for (int i = 0; i < V; ++i) {
            flag = false;
            for (ArrayList<Integer> it : edges) {
                int u = it.get(0);
                int v = it.get(1);
                int wt = it.get(2);
                if (dist[u] != maxVal && dist[u] + wt < dist[v]) {
                    if (!flag) {
                        flag = true;
                        cnt++;
                    }
                    dist[v] = dist[u] + wt;
                }
            }

        }

        if(cnt==V)return new int[]{-1};

        return dist;
    }

    public static void main(String[] args) {
        int V = 6, S = 0;
        int edges[][] = {
                {3, 2, 6},
                {5, 3, 1},
                {0, 1, 5},
                {1, 5, -3},
                {1, 2, -2},
                {3, 4, -2},
                {2, 4, 3}
        };
        ArrayList<ArrayList<Integer>> edgeList = new ArrayList<>();
        for (int i = 0; i < edges.length; ++i) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(edges[i][0]);
            list.add(edges[i][1]);
            list.add(edges[i][2]);
            edgeList.add(list);
        }
        int[] dist = bellmanFord(V, edgeList, S);
        for (int i = 0; i < dist.length; ++i) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }
}
