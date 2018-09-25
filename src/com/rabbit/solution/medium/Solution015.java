package com.rabbit.solution.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Solution015 {
    // 打了无数补丁的傻屌代码
    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>();
        for (int i : nums) {
            numbers.add(i);
        }
        Collections.sort(numbers);
        int prefix = Integer.MIN_VALUE;
        int prel = Integer.MIN_VALUE;
        int prer = Integer.MIN_VALUE;
        for (int i = 0; i < numbers.size() - 2; i++) {
            if (numbers.get(i) > 0) {
                break;
            }
            int fix = numbers.get(i);
            if (fix == prefix) {
                continue;
            }
            int l = i + 1;
            int r = numbers.size() - 1;
            while (l < r) {
                if (fix + numbers.get(l) + numbers.get(r) == 0 && (numbers.get(l) != prel || numbers.get(r) != prer)) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(fix);
                    temp.add(numbers.get(l));
                    temp.add(numbers.get(r));
                    prel = numbers.get(l);
                    prer = numbers.get(r);
                    res.add(temp);
                    --r;
                    ++l;
                } else if (numbers.get(l) + numbers.get(r) > 0 - fix) {
                    --r;
                } else {
                    ++l;
                }
            }
            prefix = fix;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] testcase = {3,0,-2,-1,1,2};
        System.out.println(threeSum(testcase));
    }
}
