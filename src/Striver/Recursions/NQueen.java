package Striver.Recursions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NQueen {
    public static List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = '.';
        List<List<String>> res = new ArrayList<>();
        boolean[] leftRow = new boolean[n];
        boolean[] majorDiagonal = new boolean[2 * n - 1];
        boolean[] minorDiagonal = new boolean[2 * n - 1];
        dfs(0, board, res, leftRow, majorDiagonal, minorDiagonal);
        return res;
    }

    private static boolean validate(char[][] board, int row, int col) {
        int duprow = row;
        int dupcol = col;
        while (row >= 0 && col >= 0) {
            if (board[row][col] == 'Q') return false;
            row--;
            col--;
        }

        row = duprow;
        col = dupcol;
        while (col >= 0) {
            if (board[row][col] == 'Q') return false;
            col--;
        }

        row = duprow;
        col = dupcol;
        while (col >= 0 && row < board.length) {
            if (board[row][col] == 'Q') return false;
            col--;
            row++;
        }
        return true;
    }

    private static void dfs(int col, char[][] board, List<List<String>> res,
                            boolean[] leftRow, boolean[] majorDiagonal, boolean[] minorDiagonal) {
        if (col == board.length) {
            res.add(construct(board));
            return;
        }

        for (int row = 0; row < board.length; row++) {
//            if (validate(board, row, col)) {
            if (!leftRow[row] && !majorDiagonal[board.length - 1 + row - col] && !minorDiagonal[row + col]) {
                board[row][col] = 'Q';
                leftRow[row] = true;
                majorDiagonal[board.length - 1 + row - col] = true;
                minorDiagonal[row + col] = true;
                dfs(col + 1, board, res, leftRow, majorDiagonal, minorDiagonal);
                board[row][col] = '.';
                leftRow[row] = false;
                majorDiagonal[board.length - 1 + row - col] = false;
                minorDiagonal[row + col] = false;
            }
        }
    }

    private static List<String> construct(char[][] board) {
        List<String> res = new LinkedList<String>();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }

    public static void main(String[] args) {
        int N = 4;
        List<List<String>> queen = solveNQueens(N);
        int i = 1;
        for (List<String> it : queen) {
            System.out.println("Arrangement " + i);
            for (String s : it) {
                System.out.println(s);
            }
            System.out.println();
            i += 1;
        }
    }
}
