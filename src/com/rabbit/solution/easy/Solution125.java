package com.rabbit.solution.easy;

public class Solution125 {
    public static boolean isPalindrome(String s) {
        String temp = s.toLowerCase();
        StringBuffer realStr = new StringBuffer();

        for (int i = 0; i < temp.length(); i++) {
            char curr = temp.charAt(i);
            if ((curr >= 97 && curr <= 122) || (curr >= 48 && curr <= 57)) {
                realStr.append(curr);
            }
        }

        for (int i = 0; i < realStr.length() / 2; i++) {
            if (realStr.charAt(i) != realStr.charAt(realStr.length() - 1 - i)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("0P"));
    }
}
