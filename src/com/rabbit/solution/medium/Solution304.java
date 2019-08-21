package com.rabbit.solution.medium;

public class Solution304 {
    // 缓存一块区域
    class NumMatrix2 {

        int[][] cache;

        public NumMatrix2(int[][] matrix) {
            if (matrix.length == 0 || matrix[0].length == 0) {
                return;
            }
            cache = new int[matrix.length + 1][matrix[0].length + 1];
            for (int i = 1; i <= matrix.length; i++) {
                for (int j = 1; j <= matrix[0].length; j++) {
                    cache[i][j] = cache[i - 1][j] + cache[i][j - 1] + matrix[i - 1][j - 1] - cache[i - 1][j - 1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return cache[row2 + 1][col2 + 1] - cache[row1][col2 + 1] - cache[row2 + 1][col1] + cache[row1][col1];
        }
    }

    // 缓存row
    class NumMatrix {

        int[][] sumMatrix;

        public NumMatrix(int[][] matrix) {
            if (matrix.length == 0) {
                return;
            }
            sumMatrix = new int[matrix.length][matrix[0].length];
            for (int i = 0; i < matrix.length; i++) {
                int sum = 0;
                for (int j = 0; j < matrix[0].length; j++) {
                    sum += matrix[i][j];
                    sumMatrix[i][j] = sum;
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            if (sumMatrix.length == 0) {
                return 0;
            }
            int sum = 0;
            for (int i = row1; i <= row2; i++) {
                sum += sumMatrix[i][col2] - (col1 - 1 >= 0 ? sumMatrix[i][col1 - 1] : 0);
            }
            return sum;
        }
    }
}
