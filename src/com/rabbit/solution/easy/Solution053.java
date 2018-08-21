package com.rabbit.solution.easy;

public class Solution053 {
    public static int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int[] currMax = new int[nums.length];
        currMax[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currMax[i] = Integer.max(nums[i], currMax[i - 1] + nums[i]);
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < currMax.length; i++) {
            if (currMax[i] > max) {
                max = currMax[i];
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
}
