package com.rabbit.solution.medium;

import java.util.*;

public class Solution015 {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; ) {
            if (nums[i] > 0) {
                break;
            }
            int fix = nums[i];
            int target = -fix;
            int l = i + 1;
            int r = nums.length - 1;
            while (i < nums.length && nums[i] == fix) {
                i++;
            }
            // now it's a two sum problem with sorted array, use two pointer
            while (l < r) {
                if (nums[l] + nums[r] == target) {
                    res.add(Arrays.asList(fix, nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    l++;
                    r--;
                } else if (nums[l] + nums[r] < target) {
                    l++;
                } else {
                    r--;
                }
            }
        }

        return res;
    }
}
