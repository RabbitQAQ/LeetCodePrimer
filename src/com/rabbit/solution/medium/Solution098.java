package com.rabbit.solution.medium;

import com.rabbit.solution.utils.TreeNode;

public class Solution098 {
    public static boolean isValidBST(TreeNode root) {
        return check(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean check(TreeNode curr, long min, long max) {
        if (curr == null) {
            return true;
        }
        return curr.val < max && curr.val > min && check(curr.left, min, curr.val) && check(curr.right, curr.val, max);
    }

    public static void main(String[] args) {

    }
}
