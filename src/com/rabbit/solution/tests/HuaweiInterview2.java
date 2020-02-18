package com.rabbit.solution.tests;

public class HuaweiInterview2 {
    static int longestContinuousSubarray(int[] nums, int k) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int currMax = 0;
            for (int j = i; j < nums.length; j++) {
                currMax += nums[j];
                if (currMax == k) {
                    max = Math.max(max, j - i + 1);
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] testcase = new int[] {1, -1, 5, -2, 3};
        int[] testcase2 = new int[] {-2, -1, 2, 1};
        int[] testcase3 = new int[] {1, -1, 5, -2, 3, 4, -6, 1, 2};
        System.out.println(longestContinuousSubarray(testcase, 3));
        System.out.println(longestContinuousSubarray(testcase2, 2));
        System.out.println(longestContinuousSubarray(testcase3, 3));
    }
}
