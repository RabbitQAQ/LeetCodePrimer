package com.rabbit.solution.hard;

public class Solution085 {
    // Not Optimal Solution, Waiting For Future Update
    public int maximalRectangle(char[][] matrix) {
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    int tj = j;
                    while (tj < matrix[0].length && matrix[i][tj] == '1') {
                        tj++;
                    }
                    int length = tj - j;
                    int width = 1;
                    int ti = i + 1;
                    res = Math.max(res, length * width);
                    while (ti < matrix.length) {
                        for (int k = j; k < tj; k++) {
                            if (matrix[ti][k] != '1') {
                                length = Math.min(length, k - j);
                                break;
                            }
                        }
                        width++;
                        ti++;
                        res = Math.max(res, length * width);
                    }

                }
            }
        }

        return res;
    }
}
