package com.rabbit.solution.medium;

import com.rabbit.solution.utils.Utils;

public class Solution073 {
    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }
        int freeRow = -1;
        int freeCol = -1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == freeRow || j == freeCol) {
                    continue;
                }
                if (matrix[i][j] == 0) {
                    if (freeRow == -1 && freeCol == -1) {
                        freeRow = i;
                        freeCol = j;
                        for (int k = 0; k < matrix[0].length; k++) {
                            matrix[freeRow][k] = matrix[freeRow][k] == 0 ? 1 : 0;
                        }
                        for (int k = 0; k < matrix.length; k++) {
                            matrix[k][freeCol] = matrix[k][freeCol] == 0 ? 1 : 0;
                        }
                    } else {
                        matrix[freeRow][j] = 1;
                        matrix[i][freeCol] = 1;
                    }
                }
            }
        }
        if (freeRow != -1 && freeCol != -1) {
            // clean up the matrix
            for (int i = 0; i < matrix[0].length; i++) {
                if (matrix[freeRow][i] == 1) {
                    setColZero(matrix, i);
                }
            }
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][freeCol] == 1) {
                    setRowZero(matrix, i);
                }
            }
        }

    }

    public void setRowZero(int[][] matrix, int row) {
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[row][i] = 0;
        }
    }

    public void setColZero(int[][] matrix, int col) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][col] = 0;
        }
    }
}
