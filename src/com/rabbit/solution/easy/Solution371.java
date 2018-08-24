package com.rabbit.solution.easy;

public class Solution371 {
    public int getSum(int a, int b) {
        if (b == 0) {
            return a;
        }
        int sumOnly = a ^ b;
        int carryOnly = (a & b) << 1;
        return getSum(sumOnly, carryOnly);
    }

    public static void main(String[] args) {

    }
}
