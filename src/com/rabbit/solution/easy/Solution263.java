package com.rabbit.solution.easy;

public class Solution263 {
    public static boolean isUgly(int num) {
        if (num == 1) {
            return true;
        } else if (num < 0) {
            return false;
        }
        while (num > 1) {
            for (int count = 2; count <= num; ) {
                if (num % count == 0 && (count == 2 || count == 3 || count == 5)) {
                    num /= count;
                } else if (num % count == 0 || count > 5) {
                    return false;
                } else {
                    count++;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        //System.out.println(isUgly(14));
        System.out.println(-200 % 3);
    }
}
