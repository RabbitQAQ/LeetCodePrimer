package com.rabbit.solution.medium;

import java.util.Arrays;

public class Solution322 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i < amount + 1; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0 && dp[i - coins[j]] != -1) {
                    min = Math.min(min, dp[i - coins[j]] + 1);
                }
            }
            dp[i] = min == Integer.MAX_VALUE ? -1 : min;
        }

        return dp[amount];
    }

    public static int coinChange2(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < coins.length; j++) {
                int remainAmount = i - coins[j];
                if (remainAmount >= 0) {
                    dp[j] = dp[j] == -1 ? dp[remainAmount] + 1 : Math.min(dp[j], dp[remainAmount] + 1);
                }
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(coinChange2(new int[] {1,2,5}, 11));
    }
}
