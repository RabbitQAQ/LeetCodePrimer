package com.rabbit.solution.easy;

public class Solution070 {
    public static int climbStairs(int n) {
        if (n < 0) {
            return 0;
        }

        int fib0 = 0;
        int fib1 = 1;
        int fib2 = 1;

        for (int i = 0; i < n; i++) {
            fib2 = fib0 + fib1;
            fib0 = fib1;
            fib1 = fib2;
        }

        return fib2;

    }

    public static void main(String[] args) {
        System.out.println(climbStairs(4));
    }
}
