package com.rabbit.solution.easy;

public class Solution067 {
    public String addBinary(String a, String b) {
        int n = a.length() - 1;
        int m = b.length() - 1;
        int carry = 0;
        StringBuilder res = new StringBuilder();
        while (n >= 0 || m >= 0) {
            int currA = n >= 0 ? a.charAt(n) - '0' : 0;
            int currB = m >= 0 ? b.charAt(m) - '0' : 0;
            int sum = currA + currB + carry;
            res.append(sum % 2);
            carry = sum / 2;
            n--;
            m--;
        }

        if (carry == 1) {
            res.append("1");
        }

        return res.reverse().toString();
    }
}
