package com.rabbit.solution.medium;

import com.rabbit.solution.utils.TreeNode;

import java.util.Stack;

public class Solution230 {
    public int kthSmallest(TreeNode root, int k) {
        TreeNode tmp = root;
        Stack<TreeNode> stack = new Stack<>();
        int count = 0;
        int res = 0;
        while (count < k) {
            while (tmp != null) {
                stack.push(tmp);
                tmp = tmp.left;
            }
            tmp = stack.pop();
            res = tmp.val;
            tmp = tmp.right;
            count++;
        }

        return res;
    }
}
