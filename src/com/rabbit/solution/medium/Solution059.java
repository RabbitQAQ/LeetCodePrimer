package com.rabbit.solution.medium;

public class Solution059 {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int left = 0;
        int top = 0;
        int right = n - 1;
        int bottom = n - 1;
        int count = 0;
        while (count < n * n) {
            for (int j = left; j <= right && count < n * n; j++) {
                res[top][j] = ++count;
            }
            top++;
            for (int j = top; j <= bottom && count < n * n; j++) {
                res[j][right] = ++count;
            }
            right--;
            for (int j = right; j >= left && count < n * n; j--) {
                res[bottom][j] = ++count;
            }
            bottom--;
            for (int j = bottom; j >= top && count < n * n; j--) {
                res[j][left] = ++count;
            }
            left++;
        }

        return res;
    }
}
