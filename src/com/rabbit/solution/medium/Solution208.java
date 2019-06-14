package com.rabbit.solution.medium;

import java.util.Arrays;

public class Solution208 {
    public static void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        if (nums.length <= 2)
            return;
        for (int i = 2; i < nums.length; i += 2){
            swap(nums, i, i - 1);
        }
    }

    public static void swap(int[] nums, int index1, int index2) {
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }

    public static void main(String[] args) {
        int[] testcase = {3,4,2,1,5,6};
        wiggleSort(testcase);
    }
}
