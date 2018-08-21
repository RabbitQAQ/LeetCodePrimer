package com.rabbit.solution.easy;

public class Solution268 {
    public static int missingNumber(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum ^= nums[i];
        }
        for (int i = 0; i < nums.length + 1; i++) {
            sum ^= i;
        }

        return sum;
    }

    public static void main(String[] args) {

    }
}
