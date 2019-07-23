package com.rabbit.solution.medium;

import com.rabbit.solution.utils.TreeNode;

public class Solution098 {
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    public boolean helper(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }
        boolean curr = false;
        if ((min == null || root.val > min) && (max == null || root.val < max)) {
            curr = true;
        }
        if (curr) {
            boolean left = helper(root.left, min, root.val);
            boolean right = helper(root.right, root.val, max);
            return left && right;
        } else {
            return false;
        }
    }
}
