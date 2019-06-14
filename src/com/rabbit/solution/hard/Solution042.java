package com.rabbit.solution.hard;

public class Solution042 {
    public static int trap(int[] height) {
        int[] dp = new int[height.length];
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            dp[i] = max;
            max = Math.max(height[i], max);
        }
        int res = 0;
        max = 0;
        for (int i = height.length - 1; i > 0; i--) {
            int min = max > dp[i] ? dp[i] : max;
            if (min > height[i])
                res += height[i] - min;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] testcase = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(testcase));
    }
}
