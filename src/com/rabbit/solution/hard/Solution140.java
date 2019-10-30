package com.rabbit.solution.hard;

import java.util.*;

public class Solution140 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<Integer, List<String>> map = new HashMap<>();
        Set<String> set = new HashSet<>(wordDict);
        return helper(s, 0, set, map);
    }

    public List<String> helper(String s, int start, Set<String> set, Map<Integer, List<String>> map) {
        if (map.containsKey(start)) {
            return map.get(start);
        }
        List<String> res = new ArrayList<>();
        if (start >= s.length()) {
            res.add("");
        }
        for (int i = start; i <= s.length(); i++) {
            String curr = s.substring(start, i);
            if (set.contains(curr)) {
                List<String> tmpRes = helper(s, i, set, map);
                for (String str : tmpRes) {
                    res.add(curr + (str.equals("") ? "" : " ") + str);
                }
                map.put(start, res);
            }
        }

        return res;
    }
}
