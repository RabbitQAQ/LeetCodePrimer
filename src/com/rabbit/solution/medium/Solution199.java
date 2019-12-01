package com.rabbit.solution.medium;

import com.rabbit.solution.utils.TreeNode;

import java.util.*;

public class Solution199 {
    public List<Integer> rightSideView2(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Map<Integer, Integer> rightMap = new TreeMap<>();
        int currDepth = 0;
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> depthStack = new Stack<>();
        nodeStack.push(root);
        depthStack.push(currDepth);
        while (!nodeStack.isEmpty()) {
            TreeNode currNode = nodeStack.pop();
            int depth = depthStack.pop();
            if (!rightMap.containsKey(depth)) {
                rightMap.put(depth, currNode.val);
            }
            if (currNode.left != null) {
                nodeStack.push(currNode.left);
                depthStack.push(depth + 1);
            }
            if (currNode.right != null) {
                nodeStack.push(currNode.right);
                depthStack.push(depth + 1);
            }
        }

        return new ArrayList<>(rightMap.values());
    }

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode tmp = queue.poll();
                if (i == n - 1) {
                    res.add(tmp.val);
                }
                if (tmp.left != null) {
                    queue.offer(tmp.left);
                }
                if (tmp.right != null) {
                    queue.offer(tmp.right);
                }
            }
        }

        return res;
    }
}
