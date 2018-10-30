package com.rabbit.solution.hard;

public class Solution010 {
    public static boolean isMatch(String s, String p) {
        if (p.isEmpty())
            return s.isEmpty();
        if (p.length() == 1) {
            return s.length() == 1 && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.');
        }
        if (p.charAt(1) != '*') {
            if (s.isEmpty()) {
                return false;
            }
            if (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.') {
                return isMatch(s.substring(1), p.substring(1));
            } else {
                return false;
            }
        } else {
            while (!s.isEmpty() && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.')) {
                if (isMatch(s, p.substring(2))){
                    return true;
                } else {
                    s = s.substring(1);
                }
            }
        }

        return isMatch(s, p.substring(2));
    }

    public static void main(String[] args) {
        System.out.println(isMatch("bbbba", ".*a*a"));
    }
}
