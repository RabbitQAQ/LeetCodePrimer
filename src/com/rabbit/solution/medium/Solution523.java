package com.rabbit.solution.medium;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution523 {
    // HashMap的方法
    public boolean checkSubarraySum2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int tmp = k == 0 ? sum : sum % k;
            if (map.containsKey(tmp)) {
                if (i - map.get(tmp) > 1) {
                    return true;
                }
            } else {
                map.put(tmp, i);
            }
        }
        return false;
    }

    // 相对Brute Force的方法，依靠累加和
    public boolean checkSubarraySum(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k || (k != 0 && sum % k == 0)) {
                    return true;
                }
            }
        }
        return false;
    }
}
