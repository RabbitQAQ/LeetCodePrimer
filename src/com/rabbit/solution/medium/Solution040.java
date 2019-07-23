package com.rabbit.solution.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution040 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new LinkedList<>();
        helper(candidates, target, 0, res, new LinkedList<>());
        return res;
    }

    public void helper(int[] candidates, int target, int start, List<List<Integer>> res, LinkedList<Integer> tmp) {
        if (target < 0) {
            return;
        } else if (target == 0) {
            res.add(new LinkedList<Integer>(tmp));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            tmp.add(candidates[i]);
            helper(candidates, target - candidates[i], i + 1, res, tmp);
            tmp.removeLast();
            while (i < candidates.length - 1 && candidates[i] == candidates[i + 1]) {
                i++;
            }
        }
    }
}
