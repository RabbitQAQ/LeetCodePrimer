package com.rabbit.solution.easy;

public class Solution342 {
    public boolean isPowerOfFour(int num) {
        return (Math.log10(num) / Math.log10(4)) - (int) (Math.log10(num) / Math.log10(4)) == 0;
    }
    public boolean isPowerOfFour2(int num) {
        if (num <= 0) {
            return false;
        }
        while (num % 4 == 0) {
            num /= 4;
        }
        return num == 1;
    }
}
