package com.rabbit.solution.easy;

public class Solution202 {
    public static boolean isHappy(int n) {
        while (true) {
            if (n == 1) {
                return true;
            } else if (n == 4) {
                return false;
            }
            n = becomeHappy(n);
        }
    }

    static int becomeHappy(int n) {
        int sum = 0;
        while (n > 0) {
            sum += Math.pow(n % 10, 2);
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(20));
    }
}
