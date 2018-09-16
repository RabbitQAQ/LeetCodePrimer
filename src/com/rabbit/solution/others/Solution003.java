package com.rabbit.solution.others;

import com.rabbit.solution.utils.TreeNode;
import com.rabbit.solution.utils.Utils;

public class Solution003 {
    // 遍历二叉树
    // 前序遍历
    public static void dlr(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val);
        dlr(root.left);
        dlr(root.right);
    }

    // 中序遍历
    public static void ldr(TreeNode root) {
        if (root == null) {
            return;
        }
        ldr(root.left);
        System.out.print(root.val);
        ldr(root.right);
    }

    // 后序遍历
    public static void lrd(TreeNode root) {
        if (root == null) {
            return;
        }
        lrd(root.left);
        lrd(root.right);
        System.out.print(root.val);
    }

    public static void main(String[] args) {
        int[] input = {1,2,3,4,5,6,7,8,9};
        TreeNode root = Utils.generateTree(input);
        dlr(root);
        System.out.println();
        ldr(root);
        System.out.println();
        lrd(root);
    }
}
