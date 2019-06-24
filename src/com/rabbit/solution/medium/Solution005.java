package com.rabbit.solution.medium;

public class Solution005 {

    // 从中心扩散寻找palindrome的方法
    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        int max = 0;
        String res = "";
        for (int i = 0; i < s.length(); ) {
            if (s.length() - i <= max / 2) {
                break;
            }
            // jump through same word
            int left = i;
            int right = i;
            while (right < s.length() - 1 && s.charAt(right) == s.charAt(right + 1)) {
                right++;
            }
            i = right + 1;
            while (left > 0 && right < s.length() - 1 && s.charAt(left - 1) == s.charAt(right + 1)) {
                left--;
                right++;
            }
            if (right - left + 1 > max) {
                max = right - left + 1;
                res = s.substring(left, right + 1);
            }
        }

        return res;
    }

    // DP
    public String longestPalindrome2(String s) {
        if (s.length() < 2) {
            return s;
        }
        // let's do it in dp!
        int max = 0, bestLeft = 0, bestRight = 0;
        int[][] dp = new int[s.length()][s.length()];
        for (int j = 0; j < s.length(); j++) {
            dp[j][j] = 1;
            for (int i = 0; i < j; i++) {
                dp[i][j] = (s.charAt(i) == s.charAt(j) && ((j - i < 2) || dp[i + 1][j - 1] == 1) ? 1 : 0);
                if (dp[i][j] == 1 && j - i + 1 > max) {
                    max = j - i + 1;
                    bestLeft = i;
                    bestRight = j;
                }
            }
        }

        return s.substring(bestLeft, bestRight + 1);
    }

    // Manacher算法 详见http://www.cnblogs.com/grandyang/p/4475985.html
    public String longestPalindrome3(String s) {
        if (s.length() < 2) {
            return s;
        }
        // prefix
        StringBuilder prefix = new StringBuilder("$#");
        for (int i = 0; i < s.length(); i++) {
            prefix.append(s.charAt(i)).append("#");
        }
        // process
        int[] p = new int[prefix.length()];
        int mx = 0, id = 0, maxRadius = 0, maxCenter = 0;
        for (int i = 1; i < prefix.length(); i++) {
            p[i] = (mx - i > 0 ? Math.min(p[2 * id - i], mx - i) : 1);
            while (i + p[i] < prefix.length() && (prefix.charAt(i + p[i]) == prefix.charAt(i - p[i]))) {
                p[i]++;
            }
            if (i + p[i] > mx) {
                mx = i + p[i];
                id = i;
            }
            if (p[i] > maxRadius) {
                maxRadius = p[i];
                maxCenter = i;
            }
        }
        return s.substring((maxCenter - maxRadius) / 2, (maxCenter - maxRadius) / 2 + maxRadius - 1);
    }
}
