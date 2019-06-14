package com.rabbit.solution.medium;

import com.rabbit.solution.utils.Utils;

public class Solution031 {
    public static void nextPermutation(int[] nums) {
        int pos = -1;
        int min = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                for (int j = nums.length - 1; j >= i; j--) {
                    if (nums[j] > nums[i]) {
                        swap(nums, i, j);
                        pos = i + 1;
                        break;
                    }
                }
                break;
            }
        }
        if (pos != -1)
            partBubble(nums, pos);
        else
            partBubble(nums, 0);
    }

    public static void swap(int[] nums, int index1, int index2) {
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }

    public static void partBubble(int[] nums, int start) {
        if (start >= nums.length - 1)
            return;
        for (int i = start; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1])
                swap(nums, i, i + 1);
        }
    }

    public static void main(String[] args) {
        int[] testcase = {3,2,1};
        nextPermutation(testcase);
        Utils.printArray(testcase);
    }
}
