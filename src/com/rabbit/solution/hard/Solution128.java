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
        int maxLength = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            int prev = curr;
            int next = curr;
            while (set.contains(prev)) --prev;
            while (set.contains(next)) ++next;
            int currLength = next - prev - 1;
            if (currLength > maxLength)
                maxLength = currLength;
        }

        return maxLength;
    }
}
