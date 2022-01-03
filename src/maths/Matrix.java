package maths;

import java.util.Scanner;

public class Matrix {
    private int[][] matrix_1;
    private int[][] matrix_2;

    public static void main(String[] args) {
        Matrix m = new Matrix();
        m.init();
        m.add(m.matrix_1, m.matrix_2);
        m.multiply(m.matrix_1, m.matrix_2);
        m.rotateByNinety(m.matrix_1);
    }

    public void init() {
        matrix_1 = this.create();
        this.print(matrix_1);
        matrix_2 = this.create();
        this.print(matrix_2);
    }

    public int[][] create() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Creating matrix:");
        System.out.println("Enter rows count");
        int row_size = sc.nextInt();
        System.out.println("Enter columns count");
        int col_size = sc.nextInt();
        int[][] matrix = new int[row_size][col_size];
        for (int i = 0; i < row_size; i++) {
            System.out.println("Enter elements for row " + (i + 1));
            for (int j = 0; j < col_size; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        return matrix;
    }

    public void add(int[][] m1, int[][] m2) {
        System.out.println("Adding two matrices:");
        if (!isAdditionPossible(m1, m2)) {
            System.out.println("ERROR:Addition not possible as dimensions of both the matrices are not equal");
            return;
        }
        int row_size = m1.length;
        int col_size = m2[0].length;
        int[][] m3 = new int[row_size][col_size];
        for (int i = 0; i < row_size; i++) {
            for (int j = 0; j < col_size; j++) {
                m3[i][j] = m1[i][j] + m2[i][j];
            }
        }
        print(m3);
    }

    public void multiply(int[][] m1, int[][] m2) {
        System.out.println("Calculating product of two matrices:");
        int row_size_m1 = m1.length;
        int row_size_m2 = m2.length;
        int col_size_m1 = m1[0].length;
        int col_size_m2 = m2[0].length;
        if (!isMultiplicationPossible(row_size_m2, col_size_m1)) {
            System.out.println("ERROR:Dimensions of matrices are not suitable for multiplication");
            return;
        }
        int[][] m3 = new int[row_size_m1][col_size_m2];
        for (int i = 0; i < row_size_m1; i++) {
            for (int j = 0; j < col_size_m2; j++) {
                m3[i][j] = m1[i][j] * m2[i][j];
            }
        }
        print(m3);
    }

    private boolean isAdditionPossible(int[][] m1, int[][] m2) {
        int col_m1 = m1[0].length;
        int col_m2 = m2[0].length;
        int row_m1 = m1.length;
        int row_m2 = m2.length;
        return (row_m1 == row_m2 && col_m1 == col_m2);
    }

    private boolean isMultiplicationPossible(int row_size, int col_size) {
        return (row_size == col_size);
    }

    public void transpose(int[][] m) {
        System.out.println("Transposing matrix:");
        if (!isSquareMatrix(m)) {
            m = transposeInNew(m);
        } else {
            m = transposeInPlace(m);
        }
        print(m);
    }

    private boolean isSquareMatrix(int[][] m) {
        return (m.length == m[0].length);
    }

    private int[][] transposeInNew(int[][] m) {
        int row = m.length;
        int col = m[0].length;
        int[][] m2 = new int[col][row];
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                m2[i][j] = m[j][i];
            }
        }
        return m2;
    }

    private int[][] transposeInPlace(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = i; j < m[0].length; j++) {
                int value = m[i][j];
                m[i][j] = m[j][i];
                m[j][i] = value;
            }
        }
        return m;
    }

    public void reverseColumns(int m[][]) {
        System.out.println("Reversing matrix columns:");
        for (int i = 0; i < m[0].length; i++) {
            for (int j = 0, k = m[0].length - 1; j < k; j++, k--) {
                int temp = m[j][i];
                m[j][i] = m[k][i];
                m[k][i] = temp;
            }
        }
        print(m);
    }

    public void rotateByNinety(int[][] m) {
        System.out.println("Rotate matrix anti-clockwise by 90 degrees:");
        transpose(m);
        reverseColumns(m);

//            Direct Approach:
//        if (!isSquareMatrix(m)) {
//            System.out.println("ERROR:Matrix is not square");
//            return;
//        } else {
//            int n = m.length;
//            for (int i = 0; i < n / 2; i++) {
//                for (int j = i; j < n - i - 1; j++) {
//                    int value = m[i][j];
//                    m[i][j] = m[j][n - i - 1];
//                    m[j][n - i - 1] = m[n - i - 1][n - j - 1];
//                    m[n - i - 1][n - j - 1] = m[n - j - 1][i];
//                    m[n - j - 1][i] = value;
//                }
//            }
//        }
//        print(m);
    }

    private void print(int[][] matrix) {
        for (int[] row : matrix) {
            for (int j = 0; j < row.length; j++) {
                System.out.print(j != 0 ? "\t|\t" + row[j] : row[j]);
            }
            System.out.println();
        }
    }
}
