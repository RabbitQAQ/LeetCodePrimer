package com.rabbit.solution.easy;

import com.rabbit.solution.utils.TreeNode;

public class Solution108 {
    public static TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    static TreeNode build(int[] nums, int low, int high) {
        if (low > high) {
            return null;
        }

        int mid = (low + high) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = build(nums, low, mid - 1);
        root.right = build(nums, mid + 1, high);

        return root;
    }

    public static void main(String[] args) {

    }
}
