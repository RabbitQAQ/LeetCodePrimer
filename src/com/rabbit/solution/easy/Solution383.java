package com.rabbit.solution.easy;

import java.util.HashMap;
import java.util.Map;

public class Solution383 {
    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> chars = new HashMap<>();
        for (int i = 0 ; i < magazine.length(); i++) {
            if (chars.containsKey(magazine.charAt(i))) {
                chars.put(magazine.charAt(i), chars.get(magazine.charAt(i)) + 1);
            } else {
                chars.put(magazine.charAt(i), 1);
            }
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            if (!chars.containsKey(ransomNote.charAt(i)) || chars.get(ransomNote.charAt(i)) == 0) {
                return false;
            } else {
                chars.put(ransomNote.charAt(i), chars.get(ransomNote.charAt(i)) - 1);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("aa", "aa"));
    }
}
