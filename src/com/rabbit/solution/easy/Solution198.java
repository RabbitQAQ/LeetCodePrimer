package com.rabbit.solution.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution198 {
    public static int rob(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return nums.length == 0 ? 0 : nums[0];
        }
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        list.add(Math.max(nums[0], nums[1]));
        for (int i = 2; i < nums.length; i++) {
            list.add(Math.max(nums[i] + list.get(i - 2), list.get(i - 1)));
        }

        return list.get(list.size() - 1);
    }
    public static void main(String[] args) {
        int[] array = {2,7,9,3,1};
        System.out.println(rob(array));
    }
}
