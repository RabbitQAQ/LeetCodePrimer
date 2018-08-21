package com.rabbit.solution.easy;

public class Solution303 {
    class NumArray {
        int[] dp;

        public NumArray(int[] nums) {
            if (nums.length == 0) {
                return;
            }
            int sum = nums[0];
            dp = new int[nums.length];
            dp[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                sum += nums[i];
                dp[i] = sum;
                //test
            }
        }

        public int sumRange(int i, int j) {
            return i == 0 ? dp[j] : dp[j] - dp[i - 1];
        }
    }
}
