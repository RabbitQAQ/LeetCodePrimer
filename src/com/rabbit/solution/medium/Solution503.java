package com.rabbit.solution.medium;

import java.util.Arrays;
import java.util.Stack;

public class Solution503 {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        for (int i = 0; i < 2 * nums.length; i++) {
            int curr = nums[i % nums.length];
            while (!stack.isEmpty() && nums[stack.peek()] < curr) {
                res[stack.pop()] = curr;
            }
            // 注意后半部分的数组只是为了找出next greater num，不能够push入stack
            if (i < nums.length) {
                stack.push(i);
            }
        }

        return res;
    }
}
