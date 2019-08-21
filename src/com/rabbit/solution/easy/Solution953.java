package com.rabbit.solution.easy;

import java.util.HashMap;
import java.util.Map;

public class Solution953 {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> hashmap = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            hashmap.put(order.charAt(i), i);
        }
        for (int i = 0; i < words.length - 1; i++) {
            if (!checkOrder(words[i], words[i + 1], hashmap)) {
                return false;
            }
        }

        return true;
    }

    public boolean checkOrder(String s1, String s2, Map<Character, Integer> hashmap) {
        int i = 0;
        while (i < s1.length() && i < s2.length()) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (hashmap.get(s1.charAt(i)) < hashmap.get(s2.charAt(i))) {
                    break;
                } else {
                    return false;
                }
            } else {
                i++;
            }
        }
        return !(i == s2.length());
    }
}
