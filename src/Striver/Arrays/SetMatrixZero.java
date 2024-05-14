package Striver.Arrays;

public class SetMatrixZero {
    public static void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean flagRow = false, flagCol = false;

        for (int j = 0; j < n; ++j) {
            if (matrix[0][j] == 0) {
                flagRow = true;
                break;
            }
        }

        for (int i = 0; i < m; ++i) {
            if (matrix[i][0] == 0) {
                flagCol = true;
                break;
            }
        }

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        System.out.println("Matrix 1");
        PrintMatrix(matrix);
        System.out.println();

        for (int i = 1; i < m; ++i) {
            if (matrix[i][0] != 0) continue;
            for (int j = 1; j < n; ++j) {
                matrix[i][j] = 0;
            }
        }
        System.out.println("Matrix 2 ");
        PrintMatrix(matrix);
        System.out.println();

        for (int j = 1; j < n; ++j) {
            if (matrix[0][j] != 0) continue;
            for (int i = 1; i < m; ++i) {
//                if (matrix[i][j] == -1) continue;
                matrix[i][j] = 0;
            }
        }

        System.out.println("Matrix 3 ");
        PrintMatrix(matrix);
        System.out.println();

        if (flagRow) {
            for (int j = 0; j < n; ++j) {
                matrix[0][j] = 0;
            }

        }
        if (flagCol) {
            for (int i = 0; i < m; ++i) {
                matrix[i][0] = 0;
            }
        }

      /*  for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == -1) matrix[i][j] = 0;
            }

        }*/
    }

    public static void PrintMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
//        int[][] myArray = {
//                {1, 1, 1},  // First row with 3 elements
//                {1, 0, 1},      // Second row with 2 elements (fewer columns are allowed)
//                {1, 1, 1} // Third row with 4 elements
//        };

//        int[][] myArray = {
//                {0, 1, 2, 0},  // First row with 3 elements
//                {3, 4, 5, 2},      // Second row with 2 elements (fewer columns are allowed)
//                {1, 3, 1, 5} // Third row with 4 elements
//        };
        int[][] myArray = {{1, 2, 3, 4}, {5, 0, 7, 8}, {0, 10, 11, 12}, {13, 14, 15, 0}};
        System.out.println("Array before : ");
        PrintMatrix(myArray);

        System.out.println();
        setZeroes(myArray);
        System.out.println("Array after : ");
        PrintMatrix(myArray);
    }
}
