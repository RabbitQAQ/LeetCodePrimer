package com.rabbit.solution.medium;

public class Solution062 {
    // 用了一位数组，降低空间复杂度
    public int uniquePaths2(int m, int n) {
        int[] dp = new int[m];
        for (int i = 0; i < m; i++) {
            dp[i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[j] = dp[j] + dp[j - 1];
            }
        }

        return dp[m - 1];
    }

    // 时间复杂度低，但是空间复杂度还能优化
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[n][m];
        for (int i = 0; i < m; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[n - 1][m - 1];
    }
}
