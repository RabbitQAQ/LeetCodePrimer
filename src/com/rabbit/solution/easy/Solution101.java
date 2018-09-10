package com.rabbit.solution.easy;

import com.rabbit.solution.utils.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

public class Solution101 {
    public static boolean isSymmetric(TreeNode root) {
        Stack<TreeNode> nodeStack = new Stack<>();
        nodeStack.push(root);
        while (!nodeStack.isEmpty()) {
            ArrayList<TreeNode> nodeList = new ArrayList<>();
            while (!nodeStack.isEmpty()) {
                nodeList.add(nodeStack.pop());
            }
            for (int i = 0; i < nodeList.size() / 2; i++) {
                TreeNode t1 = nodeList.get(i);
                TreeNode t2 = nodeList.get(nodeList.size() - 1 - i);
                if (t1 == null && t2 == null) {
                    continue;
                } else if (t1 == null) {
                    return false;
                } else if (t2 == null) {
                    return false;
                } else if (t1.val != t2.val) {
                    return false;
                }
            }
            for (TreeNode t : nodeList) {
                if (t != null) {
                    nodeStack.push(t.left);
                    nodeStack.push(t.right);
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {

    }
}
