package com.rabbit.solution.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution131 {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        helper(s, 0, res, new LinkedList<>());
        return res;
    }

    public void helper(String s, int start, List<List<String>> res, LinkedList<String> tmp) {
        if (start >= s.length()) {
            res.add(new LinkedList<String>(tmp));
            return;
        }
        StringBuilder curr = new StringBuilder();
        for (int i = start; i < s.length(); i++) {
            char c = s.charAt(i);
            curr.append(c);
            if (isPalindrome(curr.toString())) {
                tmp.add(curr.toString());
                helper(s, i + 1, res, tmp);
                tmp.removeLast();
            }
        }
    }

    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
