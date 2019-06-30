package com.rabbit.solution.easy;

public class Solution026 {
    public int removeDuplicates(int[] nums) {
        int res = 0;
        int pointer = 0;
        for (int i = 0; i < nums.length; i++) {
            nums[pointer++] = nums[i];
            res++;
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return res;
    }
}
