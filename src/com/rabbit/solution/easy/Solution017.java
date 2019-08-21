package com.rabbit.solution.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution017 {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        List<String> res = new ArrayList<>();
        helper(digits, 0, map, res, new StringBuilder());
        return res;
    }

    public void helper(String digits, int start, Map<Character, String> map, List<String> res, StringBuilder tmp) {
        if (start == digits.length()) {
            res.add(tmp.toString());
            return;
        }
        String charSet = map.get(digits.charAt(start));
        for (int i = 0; i < charSet.length(); i++) {
            tmp.append(charSet.charAt(i));
            helper(digits, start + 1, map, res, tmp);
            tmp.deleteCharAt(tmp.length() - 1);
        }
    }
}
