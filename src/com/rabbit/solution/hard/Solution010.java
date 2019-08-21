package com.rabbit.solution.hard;

public class Solution010 {
    // DP
    public boolean isMatch2(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        for (int i = 0; i <= n; i++) {
            int sIndex = i - 1;
            for (int j = 1; j <= m; j++) {
                int pIndex = j - 1;
                if (p.charAt(pIndex) == '*') {
                    if (i > 0 && (s.charAt(sIndex) == p.charAt(pIndex - 1) || p.charAt(pIndex - 1) == '.')) {
                        dp[i][j] = dp[i][j - 2] || dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i][j - 2];
                    }
                } else if (i > 0 && p.charAt(pIndex) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    if (i > 0 && s.charAt(sIndex) == p.charAt(pIndex)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }

            }
        }

        return dp[n][m];
    }

    // Recursive
    public boolean isMatch(String s, String p) {
        if (p.length() == 0) {
            return s.length() == 0;
        } else if (p.length() == 1) {
            return s.length() == 1 && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.');
        } else if (p.charAt(1) != '*') {
            return s.length() != 0 && ((s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') && isMatch(s.substring(1), p.substring(1)));
        } else {
            while (s.length() != 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
                if (isMatch(s, p.substring(2))) {
                    return true;
                }
                s = s.substring(1);
            }
            return isMatch(s, p.substring(2));
        }
    }
}
