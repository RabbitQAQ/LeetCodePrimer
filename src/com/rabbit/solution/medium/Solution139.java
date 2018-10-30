package com.rabbit.solution.medium;

import java.util.*;

public class Solution139 {
    // 这种带子集或者极值的，还是得用dp
    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (set.contains(s.substring(j, i)) && dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        String s = "ccbb";
        List<String> dict = new ArrayList<>();
        dict.add("cc");
        dict.add("bb");
        System.out.println(wordBreak(s, dict));
        //System.out.println(s.substring(0, s.indexOf("ello")) + s.substring(s.indexOf("ello") + "ello".length()));
    }
}
