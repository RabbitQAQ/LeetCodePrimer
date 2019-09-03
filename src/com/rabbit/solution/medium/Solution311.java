package com.rabbit.solution.medium;

import com.rabbit.solution.utils.ListNode;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class Solution311 {

    public int[][] multiply(int[][] A, int[][] B) {
        int n = A.length;
        int m = B[0].length;
        int[][] res = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < A[0].length; k++) {
                if (A[i][k] != 0) {
                    for (int j = 0; j < m; j++) {
                        if (B[k][j] != 0) {
                            res[i][j] = res[i][j] + A[i][k] * B[k][j];
                        }
                    }
                }
            }
        }

        return res;
    }
}
