package Striver.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
    public static boolean isCycle(List<List<Integer>> adj, int n, int src) {
        boolean[] vis = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        vis[src] = true;
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : adj.get(u)) {
                if (!vis[v]) {
                    vis[v] = true;
                    q.add(v);
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isCyclicDFS(int node, List<List<Integer>> adj, boolean[] vis, boolean[] pathVis) {
        vis[node] = true;
        pathVis[node] = true;
        for (Integer it : adj.get(node)) {
            if (!vis[it]) {
                if (isCyclicDFS(it, adj, vis, pathVis)) {
                    return true;

                }
            } else if (pathVis[it]) {
                return true;
            }

        }
        pathVis[node] = false;
        return false    ;
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; ++i) adj.add(new ArrayList<>());
        for (int[] pre : prerequisites) {
            adj.get(pre[0]).add(pre[1]);
        }

        boolean[] vis= new boolean[numCourses];
        boolean[] pathVis= new boolean[numCourses];

        for (int i = 0; i < numCourses; ++i) {
//            if (isCycle(adj, numCourses, i)) {
            if (isCyclicDFS(i,adj,vis,pathVis)) {
                return false;
            }
        }
        return true;
//        System.out.println(adj);
//        return false;
    }

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}};
        System.out.println(canFinish(numCourses, prerequisites));
        numCourses = 2;
        prerequisites = new int[][]{{1, 0}, {0, 1}};
        System.out.println(canFinish(numCourses, prerequisites));

        numCourses = 20;
        prerequisites = new int[][]{{0, 10}, {3, 18}, {5, 5}, {6, 11}, {11, 14}, {13, 1}, {15, 1}, {17, 4}};
        System.out.println(canFinish(numCourses, prerequisites));
    }
}
