package com.rabbit.solution.medium;

import com.rabbit.solution.utils.Utils;

import java.util.Arrays;
import java.util.Collections;

public class Solution031 {
    public void nextPermutation(int[] nums) {
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                for (int j = nums.length - 1; j >= 0; j--) {
                    if (nums[j] > nums[i]) {
                        swap(nums, i, j);
                        partReverse(nums, i + 1, nums.length - 1);
                        return;
                    }
                }
                break;
            }
        }
        Arrays.sort(nums);
    }

    public void swap(int[] nums, int index1, int index2) {
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }

    public void partReverse(int[] nums, int l, int r) {
        while (l < r) {
            swap(nums, l++, r--);
        }
    }
}
