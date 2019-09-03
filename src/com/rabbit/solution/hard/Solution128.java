package com.rabbit.solution.hard;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int maxRes = 0;
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            if (set.contains(curr)) {
                int left = curr - 1;
                int right = curr + 1;
                while (set.contains(left)) {
                    set.remove(left);
                    left--;
                }
                while (set.contains(right)) {
                    set.remove(right);
                    right++;
                }
                maxRes = Math.max(maxRes, right - left - 1);
            }
        }

        return maxRes;
    }
}
