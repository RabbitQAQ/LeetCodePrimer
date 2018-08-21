package com.rabbit.solution.easy;

public class Solution121 {
    public static int maxProfit(int[] prices) {
        int profit = 0;
        int buyPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            buyPrice = Math.min(buyPrice, prices[i]);
            profit = Math.max(prices[i] - buyPrice, profit);
        }

        return profit;
    }

    public static void main(String[] args) {

    }
}
