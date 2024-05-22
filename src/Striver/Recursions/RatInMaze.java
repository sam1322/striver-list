package Striver.Recursions;

import java.util.ArrayList;
import java.util.List;

public class RatInMaze {

    public static void findPath(int i, int j, int[][] m, String path, List<String> list, int n, int[][] vis) {
        // Your code here
        if (i == n - 1 && j == n - 1) {
            System.out.println("String" + path);
            list.add(path);
            return;
        }
        if (isValid(i + 1, j, m,vis)) {
            vis[i][j] = 1;
            findPath(i + 1, j, m, path + "D", list, n,vis);
            vis[i][j] = 0;
        }
        if (isValid(i, j - 1, m,vis)) {
            vis[i][j] = 1;
            findPath(i , j - 1, m, path + "L", list, n,vis);
            vis[i][j] = 0;
        }
        if (isValid(i, j + 1, m,vis)) {
            vis[i][j] = 1;
            findPath(i , j + 1, m, path + "R", list, n,vis);
            vis[i][j] = 0;
        }
        if (isValid(i - 1, j, m,vis)) {
            vis[i][j] = 1;
            findPath(i - 1, j, m, path + "U", list, n,vis);
            vis[i][j] = 0;
        }
    }

    private static boolean isValid(int i, int j, int[][] m,int[][] vis) {
        int n = m.length;
        return i >= 0 && i < n && j >= 0 && j < n && m[i][j] != 0 && vis[i][j] == 0;
    }

    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        ArrayList<String> list = new ArrayList<>();
        int vis[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                vis[i][j] = 0;
            }
        }
        findPath(0, 0, m, "", list, n,vis);
        return list;
    }

    public static void main(String[] args) {
        int m[][] = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}};
        int n = 4;
        System.out.println(findPath(m, n));
    }
}
