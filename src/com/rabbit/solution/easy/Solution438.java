package com.rabbit.solution.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution438 {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        int n = p.length();
        for (int i = 0; i < n; i++)
            map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0) + 1);

        int left = 0, right = 0;
        int cnt = 0;
        for (; right < s.length(); ++right) {
            Character curr = s.charAt(right);
            if (map.containsKey(curr)) {
                if (map.get(curr) > 0)
                    cnt++;
                map.put(curr, map.get(curr) - 1);
            }
            if (cnt == n)
                res.add(left);
            if (right - left == n - 1) {
                if (map.containsKey(s.charAt(left))) {
                    if (map.get(s.charAt(left)) >= 0)
                        cnt--;
                    map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                }

                left++;
            }

        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
    }
}
