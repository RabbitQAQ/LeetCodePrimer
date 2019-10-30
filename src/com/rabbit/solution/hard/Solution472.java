package com.rabbit.solution.hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution472 {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            set.add(words[i]);
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (canBeConcatenated(set, words[i])) {
                res.add(words[i]);
            }
        }

        return res;
    }

    public boolean canBeConcatenated(Set<String> set, String word) {
        if (word.equals("")) {
            return false;
        }
        boolean[] dp = new boolean[word.length() + 1];
        dp[0] = true;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (!(j == 0 && i == dp.length - 1) && dp[j] && set.contains(word.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[dp.length - 1];
    }
}
