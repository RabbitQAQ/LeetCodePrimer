package com.rabbit.solution.easy;

public class Solution342 {
    public boolean isPowerOfFour(int num) {
        return (Math.log10(num) / Math.log10(4)) - (int) (Math.log10(num) / Math.log10(4)) == 0;
    }
    public static void main(String[] args) {

    }
}
