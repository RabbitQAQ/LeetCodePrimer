package com.rabbit.solution.easy;

public class Solution680 {
    public boolean validPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (s.charAt(l) == s.charAt(r) && l < r) {
            l++;
            r--;
        }
        if (l >= r || isPalindrome(s.substring(l,r))
                || isPalindrome(s.substring(l + 1, r + 1)))
            return true;
        return false;
    }

    public boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r))
                return false;
            l++;
            r--;
        }

        return true;
    }

    public static void main(String[] args) {

    }
}
