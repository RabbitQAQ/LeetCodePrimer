package com.rabbit.solution.easy;

public class Solution680 {
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        boolean isDeleted = false;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                if (isValid(s, left, right - 1) || isValid(s, left + 1, right)) {
                    return true;
                } else {
                    return false;
                }
            }
            left++;
            right--;
        }

        return true;
    }

    public boolean isValid(String s, int left, int right) {
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
