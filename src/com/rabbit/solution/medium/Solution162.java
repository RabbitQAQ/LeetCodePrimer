package com.rabbit.solution.medium;

public class Solution162 {
    public static int findPeakElement(int[] nums) {
        if (nums.length == 1)
            return 0;
        int[] newNums = new int[nums.length + 2];
        System.arraycopy(nums, 0, newNums, 1, nums.length);
        newNums[0] = Integer.MIN_VALUE;
        newNums[newNums.length - 1] = Integer.MIN_VALUE;
        for (int i = 1; i < newNums.length - 1; i++) {
            if (newNums[i] > newNums[i - 1] && newNums[i] > newNums[i + 1])
                return i - 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] testcase = {1,2};
        System.out.println(findPeakElement(testcase));
    }
}
