package com.rabbit.solution.easy;

import com.rabbit.solution.utils.TreeNode;

import java.util.Stack;

public class Solution226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    // 利用stack DFS的做法
    public TreeNode invertTree2(TreeNode root) {
        TreeNode tmp = root;
        Stack<TreeNode> stack = new Stack<>();
        while (tmp != null) {
            stack.push(tmp);
            tmp = tmp.left;
        }
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            TreeNode nextRight = curr.right;
            TreeNode t = curr.left;
            curr.left = curr.right;
            curr.right = t;
            while (nextRight != null) {
                stack.push(nextRight);
                nextRight = nextRight.left;
            }
        }

        return root;
    }
}
