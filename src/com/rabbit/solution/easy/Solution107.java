package com.rabbit.solution.easy;

import com.rabbit.solution.easy.utils.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.*;

public class Solution107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        while (!nodeQueue.isEmpty()) {
            Queue<TreeNode> nodeQueueTemp = new LinkedList<>();
            while (!nodeQueue.isEmpty()) {
                nodeQueueTemp.offer(nodeQueue.poll());
            }

            List<Integer> tempList = new ArrayList<>();
            while (!nodeQueueTemp.isEmpty()) {
                TreeNode currNode = nodeQueueTemp.poll();
                tempList.add(currNode.val);
                if (currNode.left != null) {
                    nodeQueue.offer(currNode.left);
                }
                if (currNode.right != null) {
                    nodeQueue.offer(currNode.right);
                }
            }
            result.add(tempList);
        }


        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {

    }
}
