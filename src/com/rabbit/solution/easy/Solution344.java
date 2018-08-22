package com.rabbit.solution.easy;

public class Solution344 {
    public String reverseString(String s) {
        StringBuffer res = new StringBuffer();
        for (int i = s.length() - 1; i >= 0; i--) {
            res.append(s.charAt(i));
        }
        return res.toString();
    }

    public static void main(String[] args) {
    }
}
