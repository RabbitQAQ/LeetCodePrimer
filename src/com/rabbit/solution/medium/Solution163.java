package com.rabbit.solution.medium;

import java.util.ArrayList;
import java.util.List;

public class Solution163 {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        int next = lower;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < next) {
                continue;
            } else if (nums[i] == next) {
                if (next != Integer.MAX_VALUE) {
                    next++;
                }
                continue;
            } else {
                // nums[i] > next
                res.add(generate(next, nums[i] - 1));
                next = nums[i] == Integer.MAX_VALUE ? Integer.MAX_VALUE : nums[i] + 1;
                if (next == Integer.MAX_VALUE) {
                    break;
                }
            }
        }

        if (next != Integer.MAX_VALUE && next <= upper) {
            res.add(generate(next, upper));
        }

        return res;
    }

    public String generate(int a, int b) {
        return a == b ? String.valueOf(a) : String.valueOf(a + "->" + b);
    }
}
