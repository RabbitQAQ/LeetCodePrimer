package com.rabbit.solution.easy;

import java.util.HashMap;
import java.util.Map;

public class Solution387 {
    public static int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }

        int index = s.length();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                if (s.indexOf(entry.getKey()) < index) {
                    index = s.indexOf(entry.getKey());
                }
            }
        }

        return index == s.length() ? -1 : index;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("leeltcode"));
    }
}
