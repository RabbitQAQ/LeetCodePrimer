package com.rabbit.solution.utils;

import java.util.LinkedList;
import java.util.Queue;

public class Utils {
    public static void printListNode(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
    }

    public static TreeNode generateTree(int[] nodes) {
        if (nodes.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(nodes[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        for (int i = 1; i < nodes.length; i++) {
            TreeNode temp = queue.poll();
            temp.left = new TreeNode(nodes[i]);
            if (++i < nodes.length) {
                temp.right = new TreeNode(nodes[i]);
            }
            queue.add(temp.left);
            queue.add(temp.right);
        }

        return root;
    }

    public static ListNode generateList(int[] nodes) {
        if (nodes.length == 0) {
            return null;
        }
        ListNode root = new ListNode(nodes[0]);
        ListNode temp = root;
        for (int i = 1; i < nodes.length; i++) {
            temp.next = new ListNode(nodes[i]);
            temp = temp.next;
        }

        return root;
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
