package com.rabbit.solution.easy;

import com.rabbit.solution.utils.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
