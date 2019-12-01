package com.rabbit.solution.easy;

public class Solution007 {

    public int reverse(int x) {
        int res = 0;
        boolean isNegtive = false;
        if (x < 0) {
            isNegtive = true;
            x = -x;
        }
        while (x > 0) {
            int curr = x % 10;
            res += curr;
            x /= 10;
            if (x > 0) {
                if ((res > Integer.MAX_VALUE / 10 || res == Integer.MAX_VALUE && res > 7)
                        || (res < Integer.MIN_VALUE / 10 || res == Integer.MIN_VALUE / 10 && res < -8)) {
                    return 0;
                }
                res *= 10;
            }
        }

        return isNegtive ? -res : res;
    }
}
