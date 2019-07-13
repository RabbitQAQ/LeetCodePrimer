package com.rabbit.solution.easy;

import com.rabbit.solution.utils.TreeNode;

public class Solution129 {
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    public int helper(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return sum * 10 + root.val;
        }
        sum = sum * 10 + root.val;
        int leftSum = helper(root.left, sum);
        int rightSum = helper(root.right, sum);

        return leftSum + rightSum;
    }
}
