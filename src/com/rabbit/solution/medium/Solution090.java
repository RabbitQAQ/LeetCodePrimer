package com.rabbit.solution.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution090 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        helper(nums, 0, res, new LinkedList<>());
        return res;
    }

    public void helper(int[] nums, int start, List<List<Integer>> res, LinkedList<Integer> tmp) {
        if (start >= nums.length) {
            res.add(new LinkedList<>(tmp));
            return;
        }
        res.add(new LinkedList<>(tmp));
        for (int i = start; i < nums.length; i++) {
            tmp.add(nums[i]);
            helper(nums, i + 1, res, tmp);
            tmp.removeLast();
            while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                i++;
            }
        }
    }
}
