package com.rabbit.solution.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution046 {
    public static List<List<Integer>> permute(int[] nums) {
        List<Integer> available = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            available.add(0);
        }
        List<Integer> out = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        permuteDFS(nums, available, out, res);
        return res;
    }

    public static void permuteDFS(int[] nums, List<Integer> available, List<Integer> out, List<List<Integer>> res) {
        if (out.size() == nums.length) {
            List<Integer> temp = new ArrayList<>();
            temp.addAll(out);
            res.add(temp);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (available.get(i) == 0) {
                available.set(i, 1);
                out.add(nums[i]);
                permuteDFS(nums, available, out, res);
                out.remove(out.size() - 1);
                available.set(i, 0);
            }

        }
    }


    public static void main(String[] args) {
        int[] testcase = {1, 2, 3};
        System.out.println(permute(testcase));
    }
}
