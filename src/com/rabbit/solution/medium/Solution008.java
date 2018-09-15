package com.rabbit.solution.medium;

public class Solution008 {
    public static int myAtoi(String str) {
        int start = 0, end = 0;
        boolean isNegetive = false;
        // 去空格
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                start++;
            } else {
                break;
            }
        }
        end = start;
        if (start == str.length()) {
            return 0;
        }
        // 取字符
        if (str.charAt(start) == '+' || str.charAt(start) == '-') {
            isNegetive = str.charAt(start) == '-';
            start++;
            end++;
        }
        for (int i = start; i < str.length(); i++) {
            char curr = str.charAt(i);
            if (curr >= '0' && curr <= '9') {
                end = i + 1;
            } else {
                break;
            }
        }

        if (end == start) return 0;

        int limit = isNegetive ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum *= 10;
            sum += str.charAt(i) - '0';
            if ((i < end - 1 && sum > Integer.MAX_VALUE / 10) || (sum & Integer.MIN_VALUE) == Integer.MIN_VALUE) {
                return limit;
            }
        }

        return isNegetive ? -sum : sum;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("2147483646"));
    }
}
