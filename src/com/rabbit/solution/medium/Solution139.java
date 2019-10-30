package com.rabbit.solution.medium;

import java.util.*;

public class Solution139 {
    // 带memo的backtracking / DFS
    public boolean wordBreak2(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>();
        int[] memo = new int[s.length()];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = -1;
        }
        for (int i = 0; i < wordDict.size(); i++) {
            dict.add(wordDict.get(i));
        }
        LinkedList ss = new LinkedList();
        return helper(s, 0, dict, memo);
    }

    public boolean helper(String s, int start, Set<String> wordDict, int[] memo) {
        if (start >= s.length()) {
            return true;
        }
        if (memo[start] != -1) {
            return memo[start] == 1;
        }
        for (int i = start; i < s.length(); i++) {
            if (wordDict.contains(s.substring(start, i + 1))) {
                if (helper(s, i + 1, wordDict, memo)) {
                    memo[i] = 1;
                    return true;
                }
            }
        }
        memo[start] = 0;
        return false;
    }

    // 这种带子集或者极值的，还是得用dp
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>();
        for (int i = 0; i < wordDict.size(); i++) {
            dict.add(wordDict.get(i));
        }
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
