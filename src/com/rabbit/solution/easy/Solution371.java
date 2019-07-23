package com.rabbit.solution.easy;

public class Solution371 {
    public int getSum(int a, int b) {
        if (a == 0 || b == 0) {
            return a == 0 ? b : a;
        }
        return getSum(a ^ b, (a & b) << 1);
    }
}
