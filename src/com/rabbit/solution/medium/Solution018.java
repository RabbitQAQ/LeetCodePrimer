package com.rabbit.solution.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution018 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            int fix = nums[i];
            int newTarget = target - fix;
            List<List<Integer>> tmp = threeSum(nums, i + 1, newTarget, fix);
            res.addAll(tmp);
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }

        return res;
    }

    public List<List<Integer>> threeSum(int[] nums, int start, int target, int prevFix) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i = start; i < nums.length - 2; i++) {
            int fix = nums[i];
            int l = i + 1;
            int r = nums.length - 1;
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
            while (l < r) {
                if (nums[l] + nums[r] + fix == target) {
                    res.add(Arrays.asList(nums[l], nums[r], fix, prevFix));
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    l++;
                    r--;
                } else if (nums[l] + nums[r] + fix < target) {
                    l++;
                } else {
                    r--;
                }
            }
        }

        return res;
    }
}
