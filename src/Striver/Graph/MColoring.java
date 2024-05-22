package Striver.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MColoring {

    private static boolean graphColoring(int node, List<List<Integer>> adj, boolean[] vis, int[] color, int m) {
        vis[node] = true;
        List<Integer> adjNodes = adj.get(node);
        boolean flag = true;
        System.out.println("Node " + node);
        System.out.println("Adj nodes " + adjNodes);
        for (int i = 0; i < m; ++i) {
            flag = true;
            for (int j = 0; j < adjNodes.size(); ++j) {
                int adjNode = adjNodes.get(j);
                if (i == color[adjNode]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                color[node] = i;
                break;
            }
        }
        if (!flag) return false;
        System.out.print("color ");
        printArr(color);
        for (int j = 0; j < adjNodes.size(); ++j) {
            int adjNode = adjNodes.get(j);
            if (!vis[adjNode]) {
                boolean val = graphColoring(adjNode, adj, vis, color, m);
                if (val) return true;
            }
        }
        return true;
    }

    private static void printArr(int[] arr) {
        for (int i : arr)
            System.out.print(i + " ");
        System.out.println();
    }

    public static boolean graphColoring(boolean graph[][], int m, int n) {
        // Your code here
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (graph[i][j]) {
                    adj.get(i).add(j);
                }
            }
        }
        boolean[] vis = new boolean[n];
        int[] color = new int[n];
        Arrays.fill(color, -1);
//        boolean val = graphColoring(0, adj, vis, color, m);
        boolean val = solve(0, adj, color, n, m);
        for (int i = 0; i < color.length; ++i) {
            System.out.println("index " + i + " : " + color[i]);
        }
        return val;

    }

    private static boolean isSafe(int node, List<List<Integer>> graph, int[] color, int n, int col) {
        for (int it : graph.get(node)) {
            if (color[it] == col) return false;
        }
        return true;
    }

    private static boolean solve(int node, List<List<Integer>> graph, int[] color, int n, int m) {
        if (node == n) return true;
        for (int i = 1; i <= m; ++i) {
            if (isSafe(node, graph, color, n, i)) {
                color[node] = i;
                if (solve(node + 1, graph, color, n, m)) return true;
                color[node] = -1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tc = scan.nextInt();

        while (tc-- > 0) {
            int N = scan.nextInt();
            int M = scan.nextInt();
            int E = scan.nextInt();

            boolean graph[][] = new boolean[N][N];

            System.out.println();
            System.out.println("E : " + E);
            for (int i = 0; i < E; i++) {
                int u = scan.nextInt();
                int v = scan.nextInt();
                System.out.println("u : " + u + ", v : " + v);
                graph[u][v] = true;
                graph[v][u] = true;
            }

            System.out.println(graphColoring(graph, M, N) ? 1 : 0);
        }
    }
}

/*
1
4
3
5
0 1
1 2
2 3
3 0
0 2
* */