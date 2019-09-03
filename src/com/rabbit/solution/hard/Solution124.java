package com.rabbit.solution.hard;

import com.rabbit.solution.utils.TreeNode;

public class Solution124 {
    private int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return res;
    }

    public int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSum = Math.max(helper(root.left), 0);
        int rightSum = Math.max(helper(root.right), 0);
        res = Math.max(res, leftSum + rightSum + root.val);
        return root.val + Math.max(leftSum, rightSum);
    }
}
