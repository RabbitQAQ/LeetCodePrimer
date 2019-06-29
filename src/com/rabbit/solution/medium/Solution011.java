package com.rabbit.solution.medium;

import java.util.List;

public class Solution011 {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int res = 0;
        while (l < r) {
            res = Math.max(res, Math.min(height[r], height[l]) * (r - l));
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }

        return res;
    }
}
