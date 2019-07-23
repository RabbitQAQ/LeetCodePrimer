package com.rabbit.solution.medium;

import java.util.*;

public class Solution047 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        helper(nums, new int[nums.length], res, new LinkedList<Integer>());
        return res;
    }

    public void helper(int[] nums, int[] visited, List<List<Integer>> res, LinkedList<Integer> tmp) {
        if (tmp.size() == nums.length) {
            res.add(new LinkedList<Integer>(tmp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] != 1) {
                if (i > 0 && nums[i] == nums[i - 1] && visited[i - 1] == 0) {
                    continue;
                }
                visited[i] = 1;
                tmp.add(nums[i]);
                helper(nums, visited, res, tmp);
                visited[i] = 0;
                tmp.removeLast();
            }
        }
    }
}
