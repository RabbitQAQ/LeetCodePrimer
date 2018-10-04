package com.rabbit.solution.medium;

import com.rabbit.solution.utils.Utils;

public class Solution075 {
    public static void sortColors(int[] nums) {
        int left = 0, right = nums.length - 1;
        for (int i = 0; i <= right; i++) {
            if (nums[i] == 0) {
                int temp = nums[left];
                nums[left] = 0;
                nums[i] = temp;
                left++;
            } else if (nums[i] == 2) {
                int temp = nums[right];
                nums[right] = 2;
                nums[i] = temp;
                right--;
                // 神之一手
                i--;
            }
        }
    }

    public static void main(String[] args) {
        int[] testcase = {1,2,0};
        sortColors(testcase);
        Utils.printArray(testcase);
    }
}
