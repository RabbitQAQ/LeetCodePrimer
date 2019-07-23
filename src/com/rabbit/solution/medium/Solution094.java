package com.rabbit.solution.medium;

import com.rabbit.solution.utils.TreeNode;

import java.util.*;

public class Solution094 {
    // 这种写法虽然有点长但是更符合直觉
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode tmp = root;
        while (tmp != null) {
            stack.push(tmp);
            tmp = tmp.left;
        }
        while (!stack.isEmpty()) {
            TreeNode t = stack.pop();
            res.add(t.val);
            t = t.right;
            while (t != null) {
                stack.push(t);
                t = t.left;
            }
        }

        return res;
    }
    // 这种写法挺精炼的
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
