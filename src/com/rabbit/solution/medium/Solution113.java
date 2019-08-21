package com.rabbit.solution.medium;

import com.rabbit.solution.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root, sum, res, new LinkedList<>());
        return res;
    }

    public void helper(TreeNode root, int sum, List<List<Integer>> res, LinkedList<Integer> tmp) {
        if (root == null) {
            return;
        } else if (root.left == null && root.right == null) {
            if (sum == root.val) {
                tmp.add(root.val);
                res.add(new LinkedList<Integer>(tmp));
                tmp.removeLast();
            }
            return;
        }
        tmp.add(root.val);
        helper(root.left, sum - root.val, res, tmp);
        helper(root.right, sum - root.val, res, tmp);
        tmp.removeLast();
    }
}
