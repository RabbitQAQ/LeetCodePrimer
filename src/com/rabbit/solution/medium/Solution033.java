package com.rabbit.solution.medium;

import java.util.ArrayList;
import java.util.List;

public class Solution033 {
    public int search2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] >= nums[left]) { // 注意大于等于
                // 注意小于等于
                if (nums[left] <= target && nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // 注意大于等于
                if (nums[mid] < target && nums[right] >= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        return helper(nums, 0, nums.length - 1, target);
    }

    public int helper(int[] nums, int l, int r, int target) {
        if (l > r) {
            return -1;
        }
        int mid = l + (r - l) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < nums[r]) {
            if (nums[mid] < target && nums[r] >= target) {
                return helper(nums, mid + 1, r, target);
            } else {
                return helper(nums, l, mid - 1, target);
            }
        } else {
            if (nums[mid] > target && nums[l] <= target) {
                return helper(nums, l, mid - 1, target);
            } else {
                return helper(nums, mid + 1, r, target);
            }
        }
    }
}
