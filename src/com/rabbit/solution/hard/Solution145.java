package com.rabbit.solution.hard;

import com.rabbit.solution.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution145 {
    public List<Integer> postorderTraversal2(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        LinkedList<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode tmp = stack.pop();
            res.addFirst(tmp.val);
            if (tmp.left != null) {
                stack.push(tmp.left);
            }
            if (tmp.right != null) {
                stack.push(tmp.right);
            }
        }

        return res;
    }

    public List<Integer> postorderTraversal1(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode head = root;
        while (!stack.isEmpty()) {
            TreeNode tmp = stack.peek();
            if ((tmp.left == null && tmp.right == null) || tmp.left == head || tmp.right == head) {
                res.add(tmp.val);
                stack.pop();
                head = tmp;
            } else {
                if (tmp.right != null) {
                    stack.push(tmp.right);
                }
                if (tmp.left != null) {
                    stack.push(tmp.left);
                }
            }
        }

        return res;
    }
}
