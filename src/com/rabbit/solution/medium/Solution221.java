package com.rabbit.solution.medium;

public class Solution221 {

    // DFS + memo
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int res = Integer.MIN_VALUE;
        int[][] memo = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                memo[i][j] = -1;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    res = Math.max(res, helper(matrix, memo, i, j));
                }
            }
        }

        return res * res;
    }

    public int helper(char[][] matrix, int[][] memo, int i, int j) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] == '0') {
            return 0;
        }
        int right = 0;
        int left = 0;
        int diag = 0;
        if (j + 1 < matrix[0].length &&  memo[i][j + 1] != -1) {
            right = memo[i][j + 1] + 1;
        } else {
            right = helper(matrix, memo, i, j + 1) + 1;
        }
        if (j + 1 < matrix[0].length && i + 1 < matrix.length &&  memo[i + 1][j + 1] != -1) {
            diag = memo[i + 1][j + 1] + 1;
        } else {
            diag = helper(matrix, memo, i + 1, j + 1) + 1;
        }
        if (i + 1 < matrix.length &&  memo[i + 1][j] != -1) {
            left = memo[i + 1][j] + 1;
        } else {
            left = helper(matrix, memo, i + 1, j) + 1;
        }

        memo[i][j] = Math.min(right, Math.min(diag, left));

        return memo[i][j];
    }
}
