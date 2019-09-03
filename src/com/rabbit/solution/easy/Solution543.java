package com.rabbit.solution.easy;

import com.rabbit.solution.utils.TreeNode;

public class Solution543 {
    int res;
    public int diameterOfBinaryTree(TreeNode root) {
        res = 1;
        depth(root);
        return res - 1;
    }

    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        this.res = Math.max(res, leftDepth + rightDepth + 1);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
