package com.rabbit.solution.easy;

public class Solution326 {
    public static boolean isPowerOfThree(int n) {
        return (Math.log10(n) / Math.log10(3)) - (int) (Math.log10(n) / Math.log10(3)) == 0;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfThree(27));
    }
}
