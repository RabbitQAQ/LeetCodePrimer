package com.rabbit.solution.easy;

public class Solution231 {
    public static boolean isPowerOfTwo(int n) {
        while (true) {
            if (n % 2 != 0 && n != 1) {
                return false;
            }
            if (n == 1) {
                return true;
            } else if (n == 0) {
                return false;
            }

            n /= 2;
        }
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(9));
    }
}
