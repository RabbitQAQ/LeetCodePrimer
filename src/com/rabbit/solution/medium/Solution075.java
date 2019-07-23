package com.rabbit.solution.medium;

import com.rabbit.solution.utils.Utils;

public class Solution075 {

    // 略微改进版，通过nums[i] == 0时的i++来代替原本if里面的i != p0(p2)条件
    public void sortColors2(int[] nums) {
        int p0 = 0;
        int p2 = nums.length - 1;
        for (int i = 0; i < p2 + 1; ) {
            if (nums[i] == 0) {
                swap(nums, p0++, i++);
            } else if (nums[i] == 2) {
                swap(nums, p2--, i);
            } else {
                i++;
            }
        }
    }

    public void sortColors(int[] nums) {
        int p0 = 0;
        int p2 = nums.length - 1;
        for (int i = 0; i < p2 + 1; ) {
            if (nums[i] == 0 && i != p0) {
                swap(nums, p0++, i);
            } else if (nums[i] == 2 && i != p2) {
                swap(nums, p2--, i);
            } else {
                i++;
            }
        }
    }

    public void swap(int[] nums, int p1, int p2) {
        int tmp = nums[p1];
        nums[p1] = nums[p2];
        nums[p2] = tmp;
    }
}
