package com.rabbit.solution.medium;

import com.rabbit.solution.utils.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class Solution366 {
    public static List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        while (root != null) {
            List<Integer> tmp = new ArrayList<>();
            root = helper(root, tmp);
            res.add(tmp);
        }
        return res;
    }

    public static TreeNode helper(TreeNode root, List<Integer> res) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            res.add(root.val);
            return null;
        }
        root.left = helper(root.left, res);
        root.right = helper(root.right, res);
        return root;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        node1.left = node2;
        node2.left = node4;
        node2.right = node5;
        node1.right = node3;

        System.out.println(findLeaves(node1));
    }
}
