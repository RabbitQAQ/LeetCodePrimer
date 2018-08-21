package com.rabbit.solution.easy;

import com.rabbit.solution.easy.utils.TreeNode;

public class Solution111 {
    public static int minDepth(TreeNode root) {
        return getMinDepth(root);
    }

    static int getMinDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int left = getMinDepth(root.left);
        int right = getMinDepth(root.right);

        if (root.left == null) {
            return 1 + right;
        }
        if (root.right == null) {
            return 1 + left;
        }

        return 1 + Math.min(left, right);
    }

    public static void main(String[] args) {

    }
}
