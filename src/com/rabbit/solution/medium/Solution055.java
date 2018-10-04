package com.rabbit.solution.medium;

public class Solution055 {
    public static boolean canJump(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                // backward
                if (i == 0) {
                    return nums.length == 1;
                }
                boolean flag = false;
                for (int j = i - 1; j >= 0; j--) {
                    if (nums[j] + j > i || nums[j] + j >= nums.length - 1) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    if (i != nums.length - 1)
                        return false;
                }

            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] testcase = {2,0,0};
        System.out.println(canJump(testcase));
    }
}
