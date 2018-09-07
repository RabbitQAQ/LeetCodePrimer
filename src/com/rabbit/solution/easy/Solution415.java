package com.rabbit.solution.easy;

public class Solution415 {
    public static String addStrings(String num1, String num2) {
        StringBuffer res = new StringBuffer();
        String longer = num1.length() >= num2.length() ? num1 : num2;
        String shorter = num1.length() >= num2.length() ? num2 : num1;
        int carry = 0;
        for (int i = 0; i < longer.length(); i++) {
            int longNum = longer.charAt(longer.length() - 1 - i) - '0';
            int shortNum = (i >= shorter.length() ? 0 : shorter.charAt(shorter.length() - 1 - i) - '0');
            int sum = longNum + shortNum + carry;
            if (sum >= 10) {
                carry = 1;
            } else {
                carry = 0;
            }
            res.append(sum % 10);
        }
        if (carry == 1) {
            res.append('1');
        }

        return res.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addStrings("9999", "1"));
    }
}
