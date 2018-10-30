package com.rabbit.solution.medium;

public class Solution238 {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = 1;
        }
        int leftProduct = 1;
        int rightProduct = 1;
        for (int i = 0, j = nums.length - 1; i < nums.length - 1; i++, j--) {
            leftProduct *= nums[i];
            rightProduct *= nums[j];
            result[i + 1] *= leftProduct;
            result[j - 1] *= rightProduct;
        }

        return result;
    }

    public static void main(String[] args) {

    }
}
