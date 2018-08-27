package com.rabbit.solution.easy;

public class Solution400 {
    public static int findNthDigit(int n) {
        int diff = 0;
        int field = 0;
        for (int i = 0 ; i < Integer.MAX_VALUE; i++) {
            int cali = cal(i);
            int calip1 = cal(i + 1);
            int calim1 = cal(i - 1);
            if (cali < n && calip1 > n) {
                diff = n - cali;
                field = i + 1;
                break;
            } else if (cali == n) {
                diff = cali - calim1;
                field = i;
                break;
            }
        }

        return String.valueOf((int)(Math.pow(10, field - 1) + (diff - 1) / field)).charAt((diff - 1) % field) - '0';

    }

    private static int cal(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i * 9 * Math.pow(10, i - 1);
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(findNthDigit(10));
    }
}
