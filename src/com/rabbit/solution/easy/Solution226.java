package com.rabbit.solution.easy;

import com.rabbit.solution.easy.utils.TreeNode;

public class Solution226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tmp = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = tmp;

        return root;
    }

    public static void main(String[] args) {

    }
}
