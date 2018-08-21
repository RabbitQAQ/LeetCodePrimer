package com.rabbit.solution.easy;

public class Solution136 {
    // 用异或的结合律来解  X^X = 0
    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }

        return result;
    }

    public static void main(String[] args) {

    }
}
