package com.rabbit.solution.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution046 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(nums, new int[nums.length], res, new LinkedList<>());
        return res;
    }

    public void helper(int[] nums, int[] visited, List<List<Integer>> res, LinkedList<Integer> tmp) {
        if (tmp.size() == nums.length) {
            res.add(new LinkedList<Integer>(tmp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] != 1) {
                visited[i] = 1;
                tmp.add(nums[i]);
                helper(nums, visited, res, tmp);
                visited[i] = 0;
                tmp.removeLast();
            }
        }
    }
}
