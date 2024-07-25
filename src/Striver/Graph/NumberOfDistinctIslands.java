package Striver.Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberOfDistinctIslands {
    private static int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    private static String toString(int r, int c) {
        return Integer.toString(r) + " " + Integer.toString(c);
    }

    private static void dfs(int[][] grid, int[][] visited, List<String> list, int vx, int vy, int ux, int uy) {
        visited[vx][vy] = 1;
        list.add(toString(vx, vy));
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < directions.length; i++) {
            int newX = vx + directions[i][0];
            int newY = vy + directions[i][1];
            if (newX >= 0 && newX < n && newY >= 0 && newY < m && grid[newX][newY] == 1 && visited[newX][newY] == 0) {
                dfs(grid, visited, list, newX, newY, ux, uy);
            }
        }
    }

    private static int countDistinctIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        Set<List<String>> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && visited[i][j] == 0) {
                    System.out.println(i + " " + j);
                    List<String> list = new ArrayList<>();
                    dfs(grid, visited, list, i, j, i, j);
                    set.add(list);
                }
            }
        }
        System.out.println(set);
        return set.size();
    }

    public static void main(String[] args) {
        int grid[][] = {
                {1, 1, 0, 1, 1},
                {1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1},
                {1, 1, 0, 1, 1}};

        char[][] grid2 = {
                {'1', '1', '0', '1', '1'},
                {'1', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '1'},
                {'1', '1', '0', '1', '1'}
        };
//        for(int i = 0 ; i < grid2.length ; i++) {
//            for(int j = 0 ; j < grid2[0].length ; j++) {
//                System.out.println(grid2[i][j]);
//            }
//        }

    int ans = countDistinctIslands(grid);
        System.out.println(ans);
}
}
