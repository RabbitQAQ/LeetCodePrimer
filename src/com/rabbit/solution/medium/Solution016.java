package com.rabbit.solution.medium;

import java.util.Arrays;

public class Solution016 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            int fix = nums[i];
            int l = i + 1;
            int r = nums.length - 1;
            while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                i++;
            }
            while (l < r) {
                if (Math.abs(target - (fix + nums[l] + nums[r])) < Math.abs(res)) {
                    res = target - (fix + nums[l] + nums[r]);
                }
                if (target > (fix + nums[l] + nums[r])) {
                    l++;
                } else if (target < (fix + nums[l] + nums[r])) {
                    r--;
                } else {
                    res = target - (fix + nums[l] + nums[r]);
                    break;
                }
            }
        }
        return target - res;
    }
}
