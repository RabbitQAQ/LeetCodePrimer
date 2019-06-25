package com.rabbit.solution.hard;

import java.util.Stack;

public class Solution042 {
    // Stack
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i < height.length; ) {
            if (stack.isEmpty() || height[i] < height[stack.peek()]) {
                stack.push(i++);
            } else {
                int t = stack.pop();
                if (stack.isEmpty()) continue;
                res += (Math.min(height[i], height[stack.peek()]) - height[t]) * (i - stack.peek() - 1);
            }
        }

        return res;
    }

    // DP
    public int trap2(int[] height) {
        int res = 0;
        int[] dp = new int[height.length];
        int leftmx = 0;
        for (int i = 0; i < height.length; i++) {
            dp[i] = leftmx;
            leftmx = Math.max(leftmx, height[i]);
        }
        int rightmx = 0;
        for (int i = height.length - 1; i >= 0; i--) {
            int minHeight = Math.min(dp[i], rightmx);
            rightmx = Math.max(rightmx, height[i]);
            if (height[i] < minHeight)
                res += minHeight - height[i];
        }

        return res;
    }

    // Two Pointer One Pass
    public int trap3(int[] height) {
        int l = 0, r = height.length - 1;
        int res = 0;
        while (l < r) {
            int min = Math.min(height[l], height[r]);
            if (min == height[l]) {
                l++;
                while (l < r && min > height[l]) {
                    res += min - height[l];
                    l++;
                }
            } else {
                r--;
                while (l < r && min > height[r]) {
                    res += min - height[r];
                    r--;
                }
            }
        }

        return res;
    }
}
