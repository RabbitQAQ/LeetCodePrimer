package com.rabbit.solution.easy;

public class Solution172 {
    public int trailingZeroes(int n) {
        int res = 0;
        while (n > 0) {
            n /= 5;
            res += n;
        }

        return res;
    }
}
