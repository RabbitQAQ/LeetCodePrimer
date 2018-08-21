package com.rabbit.solution.easy;

import java.util.HashMap;

public class Solution001 {

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.get(target - nums[i]) != null && hashMap.get(target - nums[i]) != i) {
                int[] result = new int[2];
                result[0] = i;
                result[1] = hashMap.get(target - nums[i]);

                return result;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        int[] array = {3, 2, 4};
        System.out.println(twoSum(array, 6)[0] + " " + twoSum(array, 6)[1]);
    }
}
