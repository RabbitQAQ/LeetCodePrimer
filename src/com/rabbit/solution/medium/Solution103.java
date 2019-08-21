package com.rabbit.solution.medium;

import com.rabbit.solution.utils.TreeNode;

import java.util.*;

public class Solution103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isZigzag = false;
        while (!queue.isEmpty()) {
            int length = queue.size();
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                TreeNode curr = queue.poll();
                tmp.add(curr.val);
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            if (isZigzag) {
                Collections.reverse(tmp);
            }
            isZigzag = !isZigzag;
            res.add(tmp);
        }

        return res;
    }
}
