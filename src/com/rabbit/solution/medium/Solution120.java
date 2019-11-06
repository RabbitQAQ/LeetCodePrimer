package com.rabbit.solution.medium;

import java.util.List;

public class Solution120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0) {
            return 0;
        }
        // 啊  又是一道dp题
        int[][] dp = new int[triangle.size()][triangle.size()];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> curr = triangle.get(i);
            for (int j = 0; j < curr.size(); j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + curr.get(j);
                } else if(j == curr.size() - 1) {
                    dp[i][j] = dp[i - 1][j - 1] + curr.get(j);
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + curr.get(j);
                }
            }
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < dp[dp.length - 1].length; i++) {
            res = Math.min(res, dp[dp.length - 1][i]);
        }

        return res;
    }
}
