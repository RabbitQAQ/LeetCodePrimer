package com.rabbit.solution.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution034 {
    public static int[] searchRange(int[] nums, int target) {

        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;

        int low = 0;
        int high = nums.length - 1;
        boolean flag = false;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                res[0] = mid;
                res[1] = mid;
                for (int i = mid - 1; i >= low; i--) {
                    if (nums[i] == target) {
                        res[0] = i;
                    } else
                        break;
                }
                for (int i = mid + 1; i <= high; i++) {
                    if (nums[i] == target) {
                        res[1] = i;
                    } else
                        break;
                }
                break;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }

        return res;
    }

    public static void main(String[] args) {
        int[] fuck = {5,7,7,8,8,10};
        System.out.println(searchRange(fuck, 8)[0] + " " + searchRange(fuck, 8)[1]);

        Map<String, Integer> map = new HashMap<>();

    }
}
