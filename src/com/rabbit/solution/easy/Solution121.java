package com.rabbit.solution.easy;

public class Solution121 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int low = prices[0];
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            low = Math.min(low, prices[i]);
            res = Math.max(res, prices[i] - low);
        }
        return res;
    }
}
