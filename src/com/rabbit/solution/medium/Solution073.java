package com.rabbit.solution.medium;

import com.rabbit.solution.utils.Utils;

public class Solution073 {
    public static void setZeroes(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        boolean rowEmpty = false, colEmpty = false;
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                rowEmpty = true;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                colEmpty = true;
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                killAll(matrix, i, true);
            }
        }
        for (int i = 1; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                killAll(matrix, i, false);
            }
        }
        if (rowEmpty) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }
        if (colEmpty) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }

    }

    public static void killAll(int[][] matrix, int num, boolean isRow) {
        if (isRow) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[num][i] = 0;
            }
        } else {
            for (int j = 0; j < matrix.length; j++) {
                matrix[j][num] = 0;
            }
        }

    }

    public static void main(String[] args) {
        int[][] testcase = {{0,1,2,0}, {3,4,5,2}, {1,3,1,5}};
        setZeroes(testcase);
        Utils.printMatrix(testcase);
    }
}
