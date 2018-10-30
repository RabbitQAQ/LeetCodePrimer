package com.rabbit.solution.medium;

import com.rabbit.solution.utils.TreeNode;

import java.util.*;

public class Solution103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isZigzag = false;
        while (!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int currSize = queue.size();
            for (int i = 0; i < currSize; i++) {
                TreeNode currNode = queue.poll();
                if (currNode != null) {
                    temp.add(currNode.val);
                    queue.offer(currNode.left);
                    queue.offer(currNode.right);
                }
            }
            if (isZigzag) {
                Collections.reverse(temp);
                isZigzag = false;
            } else {
                isZigzag = true;
            }
            if (!temp.isEmpty()) {
                res.add(temp);
            }

        }

        return res;
    }

    public static void main(String[] args) {

    }
}
