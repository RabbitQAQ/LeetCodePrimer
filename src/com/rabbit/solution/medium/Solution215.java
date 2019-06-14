package com.rabbit.solution.medium;

import com.rabbit.solution.utils.Utils;

public class Solution215 {
    public static int partition(int[] nums, int left, int right) {
        int mem = left;
        int pivot = nums[left++];
        while (left <= right) {
            if (nums[left] < pivot && nums[right] > pivot) {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
            }
            if (nums[left] >= pivot) ++left;
            if (nums[right] <= pivot) --right;
        }

        int temp = nums[right];
        nums[right] = pivot;
        nums[mem] = temp;

        return right;
    }

    public static void main(String[] args) {
        int[] test = {4,2,1,3,5,6,7,2,8,9};
        int i = partition(test, 0, test.length - 1);
        Utils.printArray(test);
        System.out.println(i);
    }
}
