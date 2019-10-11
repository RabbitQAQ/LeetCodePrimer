package com.rabbit.solution.medium;

import com.rabbit.solution.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution545 {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        if (root.left != null || root.right != null) {
            res.add(root.val);
        }
        leftBoundary(root.left, res);
        leafBoundary(root, res);
        rightBoundary(root.right, res);
        return res;
    }

    public void leftBoundary(TreeNode root, List<Integer> res) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }
        res.add(root.val);
        if (root.left != null) {
            leftBoundary(root.left, res);
        } else {
            leftBoundary(root.right, res);
        }
    }

    public void leafBoundary(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        } else if (root.left == null && root.right == null) {
            res.add(root.val);
            return;
        }
        leafBoundary(root.left, res);
        leafBoundary(root.right, res);
    }

    public void rightBoundary(TreeNode root, List<Integer> res) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }
        if (root.right != null) {
            rightBoundary(root.right, res);
        } else {
            rightBoundary(root.left, res);
        }
        res.add(root.val);
    }
}
