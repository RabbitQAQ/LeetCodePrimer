package com.rabbit.solution.easy;

public class Solution007 {

    public static int reverse(int x) {
        if (x >= Integer.MAX_VALUE || x <= Integer.MIN_VALUE) {
            return 0;
        }

        if (x < 0) {
            return -reverse(-x);
        }

        int result = 0;
        while (x > 0) {
            if (result > Integer.MAX_VALUE / 10 || result * 10.0 < Integer.MIN_VALUE / 10) {
                return 0;
            }
            result = result * 10 + x % 10;
            x = x / 10;
        }

        return result;
    }

    public static void main(String[] args) {
        //System.out.println(Integer.MAX_VALUE);
        System.out.println(reverse(1534236469));
    }
}
