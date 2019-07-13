package com.rabbit.solution.easy;

import java.util.HashMap;
import java.util.Map;

public class Solution169 {
    public int majorityElement(int[] nums) {
        int res = nums[0];
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                res = num;
            }
            count += num == res ? 1 : -1;
        }

        return res;
    }

    public int majorityElement2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int count = map.getOrDefault(nums[i], 0);
            map.put(nums[i], count + 1);
            if (count + 1 > nums.length / 2) {
                return nums[i];
            }
        }
        return -1;
    }

    public static int moneydp(int target) {
        int[] dp = new int[target + 1];
        dp[0] = 0;
        for (int i = 1; i < target + 1; i++) {
            int tmp1 = i - 1 >= 0 ? dp[i - 1] + 1 : Integer.MAX_VALUE;
            int tmp2 = i - 5 >= 0 ? dp[i - 5] + 1 : Integer.MAX_VALUE;
            int tmp3 = i - 11 >= 0 ? dp[i - 11] + 1 : Integer.MAX_VALUE;
            dp[i] = Math.min(tmp1, Math.min(tmp2, tmp3));
        }

        return dp[target];
    }

    public static void main(String[] args) {
        System.out.println(moneydp(15));
    }
}
