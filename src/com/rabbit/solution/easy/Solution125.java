package com.rabbit.solution.easy;

public class Solution125 {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int l = 0, r = s.length() - 1;
        while (l < r) {
            while (l < r && !((s.charAt(l) >= '0' && s.charAt(l) <= '9') || (s.charAt(l) >= 'a' && s.charAt(l) <= 'z') || (s.charAt(l) >= 'A' && s.charAt(l) <= 'Z'))) {
                l++;
            }
            while (l < r && !((s.charAt(r) >= '0' && s.charAt(r) <= '9') || (s.charAt(r) >= 'a' && s.charAt(r) <= 'z') || (s.charAt(r) >= 'A' && s.charAt(r) <= 'Z'))) {
                r--;
            }
            if (l > r || s.charAt(l) != s.charAt(r)) {
                return false;
            } else {
                l++;
                r--;
            }
        }

        return true;
    }
}
