package com.rabbit.solution.medium;

public class Solution334 {
    public boolean increasingTriplet(int[] nums) {
        int m1 = Integer.MAX_VALUE;
        int m2 = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (m1 >= nums[i]) {
                m1 = nums[i];
            } else if (m2 >= nums[i]) {
                m2 = nums[i];
            } else {
                return true;
            }
        }

        return false;
    }
}
