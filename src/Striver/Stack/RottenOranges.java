package Striver.Stack;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    private static int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public static int orangesRotting(int[][] grid) {
        int soln = 0;
        int freshOranges = 0;
        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        // put all the rotten oranges in the queue
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }
        if (freshOranges == 0) return 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int j = 0; j < size; ++j) {
                int[] cur = queue.poll();
                for (int i = 0; i < 4; ++i) {
                    int newX = cur[0] + directions[i][0];
                    int newY = cur[1] + directions[i][1];
                    if (newX >= 0 && newX < n && newY >= 0 && newY < m && grid[newX][newY] == 1) {
                        queue.add(new int[]{newX, newY});
                        freshOranges--;
                        grid[newX][newY] = 2;
                    }
                }
            }
            soln++;

        }

        if (freshOranges == 0) return soln - 1;
        return -1;
    }

    public static void main(String[] args) {
        int arr[][] = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        int rotting = orangesRotting(arr);
        System.out.println("Minimum Number of Minutes Required " + rotting);
    }
}
