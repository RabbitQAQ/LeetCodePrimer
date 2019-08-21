package com.rabbit.solution.medium;

public class Solution201 {
    public int rangeBitwiseAnd(int m, int n) {
        int count = 0;
        while (m != n) {
            m = m >> 1;
            n = n >> 1;
            count++;
        }
        return m << count;
    }
}
