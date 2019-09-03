package com.rabbit.solution.medium;

import java.util.Random;

public class Solution845 {
    public int longestMountain(int[] A) {
        int[] up = new int[A.length];
        int[] down = new  int[A.length];
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                up[i] = up[i - 1] + 1;
            }
        }
        int res = 0;
        for (int i = A.length - 2; i >= 0; i--) {
            if (A[i] > A[i + 1]) {
                down[i] = down[i + 1] + 1;
            }
            if (up[i] != 0 && down[i] != 0) {
                res = Math.max(res, up[i] + down[i] + 1);
            }
        }
        return res;
    }
}
