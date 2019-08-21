package com.rabbit.solution.medium;

public class Solution378 {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (mid >= matrix[i][n - 1]) {
                    count += n;
                } else {
                    for (int j = n - 1; j >= 0; j--) {
                        if (matrix[i][j] <= mid) {
                            count++;
                        }
                    }
                }
            }
            if (count >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }


        return left;
    }
}
