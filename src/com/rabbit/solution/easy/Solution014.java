package com.rabbit.solution.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution014 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length < 1) {
            return "";
        }
        Arrays.sort(strs);
        int i = 0, j = 0;
        StringBuilder res = new StringBuilder();
        while (i < strs[0].length() && j < strs[strs.length - 1].length() && strs[0].charAt(i) == strs[strs.length - 1].charAt(j)) {
            res.append(strs[0].charAt(i));
            i++;
            j++;
        }
        Set<Integer> set = new HashSet<>();
        return res.toString();
    }
}
