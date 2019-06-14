package com.rabbit.solution.easy;

import java.util.HashMap;
import java.util.Map;

/*
    #001 Two Sum
    Two Sum作为LeetCode第一题被刷了无数遍，但是代码上其实还是有很多可以优化的
 */

public class Solution001 {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target - nums[i])) {
                return new int[] {i, hashMap.get(target - nums[i])};
            } else {
                hashMap.put(nums[i], i);
            }
        }
        return null;
    }

}
