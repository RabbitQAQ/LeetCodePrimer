package com.rabbit.solution.medium;

import java.util.*;

public class Solution763 {
    public List<Integer> partitionLabels(String S) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = S.length() - 1; i >= 0; i--) {
            if (!map.containsKey(S.charAt(i))) {
                map.put(S.charAt(i), i);
            }
        }
        List<Integer> res = new ArrayList<>();
        Queue<Character> queue = new LinkedList<>();
        int index = 0;
        while (true) {
            if (index >= S.length()) {
                break;
            }
            int tmp = index;
            for (int i = index; i <= index; i++) {
                if (map.get(S.charAt(i)) > index) {
                    index = map.get(S.charAt(i));
                }
            }
            index++;
            res.add(index - tmp);
        }

        return res;
    }
}
