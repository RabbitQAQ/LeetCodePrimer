package com.rabbit.solution.hard;

import java.util.*;

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

    public static List<List<String>> findAllConcatenatedWordsInADictAndPrintCombinations(String[] words) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            set.add(words[i]);
        }
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            List<String> tmp = canBeConcatenated2(set, words[i]);
            if (tmp != null) {
                res.add(tmp);
            }
        }

        return res;
    }

    public static List<String> canBeConcatenated2(Set<String> set, String word) {
        if (word.equals("")) {
            return null;
        }
        boolean[] dp = new boolean[word.length() + 1];
        int[] prev = new int[word.length() + 1];
        dp[0] = true;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (!(j == 0 && i == dp.length - 1) && dp[j] && set.contains(word.substring(j, i))) {
                    dp[i] = true;
                    prev[i] = j;
                    break;
                }
            }
        }
        List<String> res = new LinkedList<>();
        int pointer = word.length();
        if (dp[pointer]) {
            while (pointer != 0) {
                res.add(0, word.substring(prev[pointer], pointer));
                pointer = prev[pointer];
            }
            return res;
        } else {
            return null;
        }

    }

    public static void main(String[] args) {
        System.out.println(findAllConcatenatedWordsInADictAndPrintCombinations(new String[] {
                "cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"
        }));
    }
}
