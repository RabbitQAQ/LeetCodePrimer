package com.rabbit.solution.easy;

public class Solution069 {
    // 此处二分法，牛顿法y = (y + x / y) / 2
    public static int mySqrt(int x) {
        int high = 46341;
        int low = 0;
        int mid = 0;

        while (low <= high) {
            if (mid == (high + low) / 2) {
                break;
            }

            mid = (high + low) / 2;
            if (mid * mid == x) {
                return mid;
            } else if (mid * mid > x) {
                high = mid;
            } else {
                low = mid;
            }
        }

        return mid;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(8));
    }
}
