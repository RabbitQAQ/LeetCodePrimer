package com.rabbit.solution.medium;

public class Solution091 {
    public static int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        int n = s.length();
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = s.charAt(i - 1) == '0' ? 0 : dp[i - 1];
            if (Integer.valueOf(s.substring(i - 2, i)) >= 10 && Integer.valueOf(s.substring(i - 2, i)) <= 26)
                dp[i] += dp[i - 2];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("1220"));
    }
}
