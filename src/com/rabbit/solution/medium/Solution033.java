package com.rabbit.solution.medium;

import java.util.ArrayList;
import java.util.List;

public class Solution033 {
    public static int search(int[] nums, int target) {
        return fuck(nums, 0, nums.length - 1, target);
    }

    public static int fuck(int[] nums, int low, int high, int target) {
        if (low > high) {
            return -1;
        }
        int mid = low + (high - low) / 2;
        if (nums[mid] == target) {
            return mid;
        }

        if (nums[mid] > nums[high]) {
            if (nums[low] <= target && nums[mid] > target) {
                return fuck(nums, low, mid - 1, target);
            } else {
                return fuck(nums, mid + 1, high, target);
            }
        } else {
            if (nums[high] >= target && nums[mid] < target) {
                return fuck(nums, mid + 1, high, target);
            } else {
                return fuck(nums, low, mid - 1, target);
            }
        }
    }

    public static void main(String[] args) {
        int[] fuck = {3,4,5,6,7,0,1,2};
        System.out.println(search(fuck, 4));
    }
}
