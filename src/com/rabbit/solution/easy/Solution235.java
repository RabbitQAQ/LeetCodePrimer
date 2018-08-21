package com.rabbit.solution.easy;

import com.rabbit.solution.easy.utils.TreeNode;

public class Solution235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode larger = p.val > q.val ? p : q;
        TreeNode smaller = p.val < q.val ? p : q;
        if (smaller.val <= root.val && larger.val >= root.val) {
            return root;
        } else if (larger.val < root.val) {
            return lowestCommonAncestor(root.left, larger, smaller);
        } else {
            return lowestCommonAncestor(root.right, larger, smaller);
        }
    }

    public static void main(String[] args) {

    }
}
