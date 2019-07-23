package com.rabbit.solution.medium;

public class Solution055 {
    // 改进思路 很快
    public boolean canJump2(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (max < i) {
                return false;
            }
            max = Math.max(max, i + nums[i]);
        }
        return max >= nums.length - 1;
    }

    // 原始思路  很慢
    public boolean canJump(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            if (dp[i] == 1) {
                for (int j = 1; j <= nums[i]; j++) {
                    if (i + j < nums.length) {
                        if (dp[i + j] == 0) {
                            dp[i + j] = 1;
                        }
                    } else {
                        break;
                    }
                }
            }
        }

        return dp[nums.length - 1] == 1;
    }
}
