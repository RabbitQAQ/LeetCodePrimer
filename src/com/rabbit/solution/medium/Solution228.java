package com.rabbit.solution.medium;

import java.util.ArrayList;
import java.util.List;

public class Solution228 {
    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0)
            return new ArrayList<>();
        List<String> res = new ArrayList<>();
        int curr = nums[0];
        boolean sign = false;
        String currStr = String.valueOf(curr);
        for (int i = 1; i < nums.length; i++) {
            curr++;
            if (nums[i] == curr) {
                sign = true;
                continue;
            } else {
                if (sign)
                    currStr = currStr + "->" + String.valueOf(curr - 1);
                res.add(currStr);
                sign = false;
                curr = nums[i];
                currStr = String.valueOf(curr);
            }
        }
        if (sign)
            currStr = currStr + "->" + String.valueOf(curr);
        res.add(currStr);

        return res;
    }

    public static void main(String[] args) {

    }
}
