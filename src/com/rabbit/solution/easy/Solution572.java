package com.rabbit.solution.easy;

import com.rabbit.solution.utils.TreeNode;

public class Solution572 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) {
            return t == null;
        } else if (s.val == t.val) {
            if (checkSubtree(s, t)) {
                return true;
            }
        }
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    public boolean checkSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        } else if (s == null && t != null || s != null && t == null) {
            return false;
        } else {
            if (s.val != t.val) {
                return false;
            } else {
                return checkSubtree(s.left, t.left) && checkSubtree(s.right, t.right);
            }
        }
    }
}
