package com.rabbit.solution.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution438 {
    public static List<Integer> findAnagrams2(String s, String p) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0) + 1);
        }
        int l = 0;
        int r = 0;
        int count = p.length();
        List<Integer> res = new ArrayList<>();
        while (r < s.length()) {
            char curr = s.charAt(r);
            if (map.containsKey(curr) && map.get(curr) >= 1) {
                map.put(curr, map.get(curr) - 1);
                count--;
            }
            r++;
            if (count == 0) {
                res.add(l);
            }
            if (r - l == p.length()) {
                if (map.containsKey(s.charAt(l))) {
                    map.put(s.charAt(l), map.get(s.charAt(l)) + 1);
                    count++;
                }
                l++;
            }
        }

        return res;
    }

    public List<Integer> findAnagrams(String s, String p) {
        int[] map = new int[256];
        for (int i = 0; i < p.length(); i++) {
            map[p.charAt(i)] += 1;
        }
        int l = 0;
        int r = 0;
        int cnt = p.length();
        List<Integer> res = new ArrayList<>();
        while (r < s.length()) {
            char curr = s.charAt(r++);
            if (map[curr]-- >= 1) {
                cnt--;
            }
            if (cnt == 0) {
                res.add(l);
            }
            if (r - l == p.length() && map[s.charAt(l++)]++ >= 0) {
                cnt++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        findAnagrams2("cbaebabacd", "abc");
    }
}
