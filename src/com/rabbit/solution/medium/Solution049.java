package com.rabbit.solution.medium;

import java.util.*;

public class Solution049 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] charArray = strs[i].toCharArray();
            Arrays.sort(charArray);
            String sorted = new String(charArray);
            if (map.containsKey(sorted)) {
                map.get(sorted).add(strs[i]);
            } else {
                List<String> tmp = new ArrayList<>();
                tmp.add(strs[i]);
                map.put(sorted, tmp);
            }
        }

        return new ArrayList<>(map.values());
    }
}
