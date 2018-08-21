package com.rabbit.solution.easy;

public class Solution189 {
    // 前length-k反转  后k反转  再总体反转
    public static void rotate(int[] nums, int k) {
        int length = nums.length;
        k %= length; // !
        reverseArray(nums, 0, length - k - 1);
        reverseArray(nums, length - k, length - 1);
        reverseArray(nums, 0, length - 1);

    }

    static void reverseArray(int[] nums, int start, int end) {
        for (; start <= (start + end) / 2; start++, end--) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
        }
    }

    public static void main(String[] args) {
        int[] array = {1};
        rotate(array, 1);
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
