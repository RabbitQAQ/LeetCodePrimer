package com.rabbit.solution.easy;

public class Solution171 {
    public static int titleToNumber(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += Math.pow(26, s.length() - 1 - i) * (s.charAt(i) - 'A' + 1);
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(titleToNumber("A"));
    }
}
