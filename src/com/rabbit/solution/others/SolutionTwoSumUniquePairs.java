package com.rabbit.solution.others;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SolutionTwoSumUniquePairs {
    public static int twoSumUniquePairs(int[] nums, int target) {
        Set<Integer> set = new HashSet<>();
        int res = 0;
        boolean sameNum = false;
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                if (set.contains(target - nums[i])) {
                    res++;
                }
                set.add(nums[i]);
            } else {
                if (nums[i] + nums[i] == target && !sameNum) {
                    res++;
                    sameNum = !sameNum;
                }
            }
        }

        return res;
    }

    public static int twoSumUniquePairs2(int[] nums, int target) {
        Map<Integer, Boolean> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                // not used
                if (!map.get(diff)) {
                    res++;
                    map.put(diff, true);
                }
                map.put(nums[i], true);
            } else {
                map.put(nums[i], false);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] testcase = {1,5,1,5, 3, 3};
        System.out.println(twoSumUniquePairs(testcase, 6));
        System.out.println(twoSumUniquePairs2(testcase, 6));
    }
}
