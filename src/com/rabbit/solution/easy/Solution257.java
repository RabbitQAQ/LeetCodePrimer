package com.rabbit.solution.easy;

import com.rabbit.solution.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution257 {
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        if (root.left == null && root.right == null) {
            result.add(String.valueOf(root.val));
        } else {
            for (String s : binaryTreePaths(root.left)) {
                result.add(root.val + "->" + s);
            }
            for (String s : binaryTreePaths(root.right)) {
                result.add(root.val + "->" + s);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);

        t1.left = t2;
        t2.right = t4;
        t1.right = t3;

        for (String s : binaryTreePaths(t1)) {
            System.out.println(s);
        }
    }
}
