package com.rabbit.solution.medium;

import java.util.List;

public class Solution011 {
    public static int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int res = 0;
        while (l < r) {
            res = Math.max(res, (r - l) * (height[l] > height[r] ? height[r] : height[l]));
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] testcase = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(testcase));
    }
}
