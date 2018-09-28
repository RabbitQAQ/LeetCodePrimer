package com.rabbit.solution.medium;

import com.rabbit.solution.utils.Utils;

public class Solution048 {
    public static void rotate(int[][] matrix) {
        // 先按斜对角翻转(这样的对角线 -> /)  之后上下翻转
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length - i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[matrix.length - 1 - j][matrix.length - 1 - i];
                matrix[matrix.length - 1 - j][matrix.length - 1 - i] = temp;
            }
        }

        for (int i = 0; i < matrix.length / 2; i++) {
            for (int j = 0; j < matrix.length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[matrix.length - 1 - i][j];
                matrix[matrix.length - 1 - i][j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] testcase = {{1,2,3},{4,5,6},{7,8,9}};
        Utils.printMatrix(testcase);
        rotate(testcase);
        Utils.printMatrix(testcase);
    }
}
