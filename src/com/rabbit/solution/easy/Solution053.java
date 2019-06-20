package com.rabbit.solution.easy;

public class Solution053 {
    // Divide and Conquer
    public int crossSum(int[] nums, int left, int right, int mid) {
        if (left >= right) {
            return nums[left];
        }
        int currLeft = 0;
        int maxLeft = Integer.MIN_VALUE;
        for (int i = mid; i >= left; i--) {
            currLeft += nums[i];
            maxLeft = Math.max(currLeft, maxLeft);
        }

        int currRight = 0;
        int maxRight = Integer.MIN_VALUE;
        for (int i = mid + 1; i <= right; i++) {
            currRight += nums[i];
            maxRight = Math.max(currRight, maxRight);
        }

        return maxLeft + maxRight;
    }

    public int helper(int[] nums, int left, int right) {
        if (left >= right) {
            return nums[left];
        }
        int mid = (left + right) / 2;
        int maxLeft = helper(nums, left, mid);
        int maxRight = helper(nums, mid + 1, right);
        int maxCross = crossSum(nums, left, right, mid);

        return Math.max(maxCross, Math.max(maxLeft, maxRight));
    }

    public int maxSubArray(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    // Greedy
    public int maxSubArray2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int res = nums[0];
        int currSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currSum = Math.max(nums[i], nums[i] + currSum);
            res = Math.max(res, currSum);
        }

        return res;
    }
}
