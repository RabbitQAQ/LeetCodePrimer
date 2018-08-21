package com.rabbit.solution.easy;

import com.rabbit.solution.easy.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution104 {
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        int count = 0;
        while (!nodeQueue.isEmpty()) {
            count++;
            Queue<TreeNode> currNodeList = new LinkedList<>();
            while (!nodeQueue.isEmpty()) {
                currNodeList.offer(nodeQueue.poll());
            }
            while (!currNodeList.isEmpty()) {
                TreeNode currNode = currNodeList.poll();
                if (currNode.left != null) {
                    nodeQueue.offer(currNode.left);
                }
                if (currNode.right != null) {
                    nodeQueue.offer((currNode.right));
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {

    }
}
