package com.rabbit.solution.medium;

public class Solution209 {

    // Binary Search
    public int minSubArrayLen2(int s, int[] nums) {
        int[] sums = new int[nums.length + 1];
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < sums.length; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        for (int i = 0; i < sums.length; i++) {
            int index = binarySearch(i + 1, nums.length, sums, sums[i] + s);
            if (index >= sums.length) {
                break;
            }
            res = Math.min(res, index - i);
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }

    public int binarySearch(int left, int right, int[] sums, int target) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (sums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    // Two Pointer
    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0] >= s ? 1 : 0;
        }
        int left = 0;
        int right = 0;
        int sum = nums[0];
        int res = Integer.MAX_VALUE;
        while (right < nums.length) {
            if (sum >= s) {
                res = Math.min(res, right - left + 1);
                sum -= nums[left];
                left++;
            } else {
                right++;
                if (right < nums.length) {
                    sum += nums[right];
                }
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }

    public static void main(String[] args) {

    }
}
