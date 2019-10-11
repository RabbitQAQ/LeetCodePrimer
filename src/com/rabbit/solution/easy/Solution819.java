package com.rabbit.solution.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution819 {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedSet = new HashSet<>();
        for(int i = 0; i < banned.length; i++) {
            bannedSet.add(banned[i]);
        }

        paragraph = paragraph.toLowerCase();
        char[] chars = paragraph.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (!(chars[i] >= 'a' && chars[i] <= 'z')) {
                chars[i] = ' ';
            }
        }
        String[] words = new String(chars).split("\\s+");
        int max = 0;
        String currWord = "";
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (!bannedSet.contains(words[i])) {
                map.put(words[i], map.getOrDefault(words[i], 0) + 1);
                if (map.get(words[i]) > max) {
                    max = map.get(words[i]);
                    currWord = words[i];
                }
            }
        }

        return currWord;
    }
}
