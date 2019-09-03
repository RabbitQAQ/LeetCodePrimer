package com.rabbit.solution.hard;

import java.util.*;

public class Solution269 {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> map = new HashMap<>();
        Set<Character> charSet = new HashSet<>();
        int[] in = new int[256];
        for (String s : words) {
            for (int i = 0; i < s.length(); i++) {
                charSet.add(s.charAt(i));
            }
        }
        for (int i = 1; i < words.length; i++) {
            String prev = words[i - 1];
            String curr = words[i];
            int min = Math.min(prev.length(), curr.length());
            int j = 0;
            while (j < min) {
                if (prev.charAt(j) != curr.charAt(j)) {
                    map.putIfAbsent(prev.charAt(j), new HashSet<>());
                    map.get(prev.charAt(j)).add(curr.charAt(j));
                    break;
                }
                j++;
            }
            if (j == min && prev.length() > curr.length()) {
                return "";
            }
        }

        for (Map.Entry<Character, Set<Character>> entry : map.entrySet()) {
            for (Character inc : entry.getValue()) {
                in[inc]++;
            }

        }

        Queue<Character> queue = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        for (char c : charSet) {
            if (in[c] == 0) {
                queue.offer(c);
                res.append(c);
            }
        }

        while (!queue.isEmpty()) {
            char curr = queue.poll();
            if (map.get(curr) != null) {
                for (Character c : map.get(curr)) {
                    in[c]--;
                    if (in[c] == 0) {
                        queue.offer(c);
                        res.append(c);
                    }
                }
            }

        }

        return res.length() == charSet.size() ? res.toString() : "";

    }

}
