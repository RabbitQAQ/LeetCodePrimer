package com.rabbit.solution.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution034 {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = binarySearchStart(nums, target);
        res[1] = binarySearchEnd(nums, target);

        return res;
    }

    public int binarySearchStart(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (left < nums.length && nums[left] == target) {
            return left;
        } else {
            return -1;
        }
    }

    public int binarySearchEnd(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (right >= 0 && nums[right] == target) {
            return right;
        } else {
            return -1;
        }
    }
}
