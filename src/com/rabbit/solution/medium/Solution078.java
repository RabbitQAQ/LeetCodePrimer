package com.rabbit.solution.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution078 {
    public List<List<Integer>> subsets(int[] nums) {
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
        }
    }
}
