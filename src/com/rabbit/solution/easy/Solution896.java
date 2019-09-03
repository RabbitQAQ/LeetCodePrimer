package com.rabbit.solution.easy;

import java.util.Map;

public class Solution896 {
    public boolean isMonotonic2(int[] A) {
        if (A.length < 2) {
            return true;
        }
        boolean increase = true;
        boolean decrease = true;
        for (int i = 1; i < A.length; i++) {
            if (A[i] - A[i - 1] > 0) {
                decrease = false;
            } else if (A[i] - A[i - 1] < 0) {
                increase = false;
            }
        }
        return increase || decrease;
    }

    public boolean isMonotonic(int[] A) {
        if (A.length < 2) {
            return true;
        }
        boolean flag = false;
        boolean isIncrease = false;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                if (!flag) {
                    isIncrease = true;
                    flag = true;
                }
                if (!isIncrease) {
                    return false;
                }
            } else if (A[i] < A[i - 1]) {
                if (!flag) {
                    isIncrease = false;
                    flag = true;
                }
                if (isIncrease) {
                    return false;
                }
            }
        }

        return true;
    }
}
