package com.rabbit.solution.easy;

public class Solution035 {
    public static int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (target > nums[i]) {
                if (i == nums.length - 1 || target < nums[i + 1]) {
                    return i + 1;
                }
            } else {
                if (target == nums[i] || target < nums[i]) {
                    return i;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int val = 4;

        System.out.println(searchInsert(nums, val));
    }
}
