package com.rabbit.solution.hard;

public class Solution123 {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        if (length < 2) {
            return 0;
        }
        int[][] local = new int[length][3];
        int[][] global = new int[length][3];
        int max = 0;
        for (int i = 1; i < length; i++) {
            int diff = prices[i] - prices[i - 1];
            for (int j = 1; j <= 2; j++) {
                local[i][j] = Math.max(global[i - 1][j - 1] + Math.max(diff, 0), local[i - 1][j] + diff);
                global[i][j] = Math.max(local[i][j], global[i - 1][j]);
                max = Math.max(max, global[i][j]);
            }
        }

        return max;
    }
}
