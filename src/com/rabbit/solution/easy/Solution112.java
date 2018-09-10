package com.rabbit.solution.easy;

import com.rabbit.solution.utils.TreeNode;

public class Solution112 {
    // 还有优化空间
    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return dfs(root, 0, sum);
    }

    static boolean dfs(TreeNode root, int num, int sum) {
        if (root == null) {
            if (num == sum) {
                return true;
            } else {
                return false;
            }
        }

        if (root.right == null) {
            return dfs(root.left, num + root.val, sum);
        }

        if (root.left == null) {
            return dfs(root.right, num + root.val, sum);
        }

        return dfs(root.right, num + root.val, sum) || dfs(root.left, num + root.val, sum);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode leaf = new TreeNode(2);
        root.right = leaf;

        System.out.println(hasPathSum(root, 1));
    }
}
