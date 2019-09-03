package com.rabbit.solution.medium;

public class Solution063 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0 || obstacleGrid[0][0] == 1) {
            return 0;
        }
        int[][] dp = new int[obstacleGrid.length + 1][obstacleGrid[0].length + 1];
        dp[0][1] = 1;
        for (int i = 1; i < obstacleGrid.length + 1; i++) {
            for (int j = 1; j < obstacleGrid[0].length + 1; j++) {
                if (obstacleGrid[i - 1][j - 1] == 1) {
                    continue;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[obstacleGrid.length][obstacleGrid[0].length];
    }
}
