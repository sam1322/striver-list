package Striver.BinaryTree;

import Striver.Arrays.ArrayImpl;

public class FloodFill {
    private static int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

//    FloodFill() {
//        directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
//    }

    private static void dfs(int[][] image, int x, int y, int color) {
        int prevColor = image[x][y];
        image[x][y] = color;
        int n = image.length;
        int m = image[0].length;
        for (int i = 0; i < directions.length; ++i) {
            int newX = x + directions[i][0];
            int newY = y + directions[i][1];
            if (newX >= 0 && newX < n && newY >= 0 && newY < m && image[newX][newY] == prevColor) {
                dfs(image, newX, newY, color);
            }
        }
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] ==color)return image;
        dfs(image, sr, sc, color);
        return image;
    }

    public static void printsoln(int[][] image, int sr, int sc, int color) {
        ArrayImpl.print2dArr(image);
        floodFill(image, sr, sc, color);
        System.out.println("new array ");
        ArrayImpl.print2dArr(image);
    }

    public static void main(String[] args) {
        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int sr = 1, sc = 1, color = 2;
        printsoln(image, sr, sc, color);
        image = new int[][]{{0, 0, 0}, {0, 0, 0}};
        sr = 0;
        sc = 0;
        color = 0;
        printsoln(image, sr, sc, color);

    }
}
