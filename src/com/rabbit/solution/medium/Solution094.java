package com.rabbit.solution.medium;

import com.rabbit.solution.utils.TreeNode;

import java.util.*;

public class Solution094 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        while (temp != null || !stack.empty()) {
            while (temp != null) {
                stack.push(temp);
                temp = temp.left;
            }
            temp = stack.pop();
            res.add(temp.val);
            temp = temp.right;
        }

        return res;
    }

    public static void main(String[] args) {

    }
}
