package com.rabbit.solution.hard;

import java.util.HashMap;
import java.util.Map;

public class Solution076 {
    public String minWindow(String s, String t) {
        Map<Character, Integer> charMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char curr = t.charAt(i);
            charMap.put(curr, charMap.getOrDefault(curr, 0) + 1);
        }
        int left = 0;
        int right = 0;
        int cnt = t.length();
        String res = "";
        int max = Integer.MAX_VALUE;
        while (right < s.length()) {
            char curr = s.charAt(right);
            if (charMap.containsKey(curr)) {
                if (charMap.get(curr) > 0) {
                    cnt--;
                }
                charMap.put(curr, charMap.get(curr) - 1);
            }
            right++;
            while (cnt == 0) {
                if (right - left < max) {
                    res = s.substring(left, right);
                    max = right - left;
                }
                if (charMap.containsKey(s.charAt(left))) {
                    charMap.put(s.charAt(left), charMap.get(s.charAt(left)) + 1);
                    if (charMap.get(s.charAt(left)) > 0) {
                        cnt++;
                    }
                }
                left++;
            }
        }

        return res;
    }
//    public static String minWindow(String s, String t) {
//        if (t.length() == 0) {
//            return "";
//        }
//        Map<Character, Integer> map = new HashMap<>();
//        for (int i = 0; i < t.length(); i++) {
//            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
//        }
//        String res = "";
//        int minLength = Integer.MAX_VALUE;
//        int count = 0;
//        int leftWin = 0;
//        for (int i = 0; i < s.length(); i++) {
//            Character curr = s.charAt(i);
//            if (map.containsKey(curr)) {
//                int newValue = map.get(curr) - 1;
//                map.put(curr, newValue);
//                if (newValue >= 0)
//                    count++;
//                while (count == t.length()) {
//                    int min = i + 1 - leftWin;
//                    if (min < minLength) {
//                        res = s.substring(leftWin, i + 1);
//                        minLength = min;
//                    }
//                    Character leftChar = s.charAt(leftWin);
//                    if (map.containsKey(leftChar)) {
//                        int tValue = map.get(leftChar) + 1;
//                        map.put(leftChar, tValue);
//                        if (tValue > 0)
//                            count--;
//                    }
//                    leftWin++;
//                }
//            }
//        }
//
//        return res;
//    }

//    public static void main(String[] args) {
//        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
//    }
}
