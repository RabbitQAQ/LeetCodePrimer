package com.rabbit.solution.medium;

import java.util.ArrayList;
import java.util.List;

public class Solution986 {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> res = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < A.length && j < B.length) {
            int[] currA = A[i];
            int[] currB = B[j];
            int start = Math.max(currA[0], currB[0]);
            int end = Math.min(currA[1], currB[1]);
            if (start <= end) {
                res.add(new int[] {start, end});
            }
            if (currA[1] >= currB[1]) {
                j++;
            } else {
                i++;
            }
        }

        int[][] trueRes = new int[res.size()][2];
        for (int k = 0; k < res.size(); k++) {
            trueRes[k][0] = res.get(k)[0];
            trueRes[k][1] = res.get(k)[1];
        }

        return trueRes;
    }
}
