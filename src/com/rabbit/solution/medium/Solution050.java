package com.rabbit.solution.medium;

public class Solution050 {
    public static double myPow(double x, int n) {
        if (n < 0)
            return 1 / pow(x, -n);
        return pow(x, n);
    }

    public static double pow(double x, int n) {
        if (n == 0)
            return 1;
        double half = pow(x, n / 2);
        return n % 2 == 0 ? half * half : half * half * x;
    }

    public static void main(String[] args) {
        System.out.println(myPow(2,Integer.MAX_VALUE));
    }
}
