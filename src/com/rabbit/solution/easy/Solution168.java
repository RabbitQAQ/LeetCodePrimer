package com.rabbit.solution.easy;

public class Solution168 {
    public static String convertToTitle(int n) {
        StringBuffer result = new StringBuffer();
        while (n > 0) {
            result.append((char) (--n % 26 + 'A'));
            n /= 26;
        }

        return result.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(convertToTitle(1));
    }
}
