package com.rabbit.solution.medium;

import java.util.ArrayList;
import java.util.List;

public class Solution300 {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int res = 1;
        for (int i = 1; i < dp.length; i++) {
            int maxVal = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxVal = Math.max(maxVal, dp[j] + 1);
                }
            }
            dp[i] = maxVal;
            res = Math.max(res, dp[i]);
        }

        return res;
    }


    public static int lengthOfLIS2(int[] nums) {
        List<Integer> dp = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int left = 0;
            int right = dp.size() - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (dp.get(mid) < nums[i]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            if (right >= dp.size() - 1) {
                dp.add(nums[i]);
            } else {
                if (right != -1) {
                    dp.set(right, nums[i]);
                }
            }
        }
        return dp.size();
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLIS2(new int[]{10,9,2,5,3,7,101,18}));
    }
}
