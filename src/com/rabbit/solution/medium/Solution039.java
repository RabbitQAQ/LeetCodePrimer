package com.rabbit.solution.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution039 {
    // Ver 2.0 Beat 78%
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();
        helper2(candidates, target, res, new LinkedList<>(), 0);
        return res;
    }

    public void helper2(int[] candidates, int target, List<List<Integer>> res, LinkedList<Integer> tmp, int start) {
        if (target < 0) {
            return;
        } else if (target == 0) {
            res.add(new LinkedList<>(tmp));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            tmp.add(candidates[i]);
            helper2(candidates, target - candidates[i], res, tmp, i);
            tmp.removeLast();
        }
    }

    // Ver 1.0  Beat 14%
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        return helper(candidates, target, 0);
    }

    public List<List<Integer>> helper(int[] candidates, int target, int start) {
        if (target < 0) {
            return new ArrayList<>();
        } else if (target == 0) {
            List<List<Integer>> res = new ArrayList<>();
            res.add(new ArrayList<>());

            return res;
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = start; i < candidates.length; i++) {
            List<List<Integer>> tmp = helper(candidates, target - candidates[i], i);
            for (List<Integer> l : tmp) {
                l.add(candidates[i]);
            }
            res.addAll(tmp);
        }

        return res;
    }
}
