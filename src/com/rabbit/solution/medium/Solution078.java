package com.rabbit.solution.medium;

import java.util.ArrayList;
import java.util.List;

public class Solution078 {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> resTemp = new ArrayList<>();
            for (int j = 0; j < res.size(); j++) {
                List<Integer> temp = new ArrayList<>();
                temp.addAll(res.get(j));
                temp.add(nums[i]);
                resTemp.add(temp);
            }
            res.addAll(resTemp);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] testcase = {1,2,3};
        System.out.println(subsets(testcase));
    }
}
