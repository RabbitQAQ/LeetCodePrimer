package com.rabbit.solution.easy;

public class Solution674 {
    public static int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0)
            return -1;
        else if (nums.length == 1)
            return nums[0];
        int l = 0, r = 1;
        int currLength = 1, bestLength = Integer.MIN_VALUE, bestL = 0, bestR = 1;
        while (r < nums.length) {
            if (nums[r] > nums[r - 1]) {
                currLength++;
            } else {
                if (r - l > bestLength) {
                    bestL = l;
                    bestR = r;
                    bestLength = r - l;
                    l = r;
                    currLength = 1;
                }
            }
            r++;
        }

        return currLength > bestLength ? currLength: bestLength;
    }

    public static void main(String[] args) {
        int[] test = {2,2,2,2,2};
        System.out.println(findLengthOfLCIS(test));
    }
}
