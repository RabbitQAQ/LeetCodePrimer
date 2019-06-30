package com.rabbit.solution.easy;

public class Solution027 {
    public int removeElement(int[] nums, int val) {
        int res = 0;
        int pointer = 0;
        for (int i = 0; i < nums.length; i++) {
            while (i < nums.length && nums[i] == val) {
                i++;
            }
            if (i >= nums.length) {
                break;
            }
            nums[pointer++] = nums[i];
            res++;
        }

        return res;
    }
}
