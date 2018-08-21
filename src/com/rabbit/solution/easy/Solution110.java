package com.rabbit.solution.easy;

import com.rabbit.solution.easy.utils.TreeNode;

public class Solution110 {

    // isBalanced方法方便但并不高效 另一种方法是当我们发现节点不平衡时直接返回  见isBalanced2()
    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (Math.abs(getDepth(root.left) - getDepth(root.right)) > 1) {
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }

    static int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(getDepth(root.left), getDepth(root.right));
    }

    // 方法2
    public static boolean isBalanced2(TreeNode root) {
        if (checkDepth(root) != -1) {
            return true;
        } else {
            return false;
        }
    }

    static int checkDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = checkDepth(root.left);
        if (left == -1) {
            return -1;
        }

        int right = checkDepth(root.right);
        if (right == -1) {
            return -1;
        }

        if (Math.abs(left - right) > 1) {
            return -1;
        }

        return 1 + Math.max(left, right);
    }

    public static void main(String[] args) {

    }
}
