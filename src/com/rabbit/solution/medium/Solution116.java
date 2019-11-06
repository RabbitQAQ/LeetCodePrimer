package com.rabbit.solution.medium;

import com.rabbit.solution.utils.TreeLinkNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution116 {
    public static void connect(TreeLinkNode root) {
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<TreeLinkNode> temp = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeLinkNode t = queue.poll();
                if (t == null) {
                    break;
                }
                temp.add(t);
                queue.offer(t.left);
                queue.offer(t.right);
            }
            for (int i = 0; i < temp.size(); i++) {
                if (i != temp.size() - 1) {
                    temp.get(i).next = temp.get(i + 1);
                } else {
                    temp.get(i).next = null;
                }
            }
        }
    }

    public TreeLinkNode connect2(TreeLinkNode root) {
        if (root == null) {
            return null;
        }
        if (root.left != null) {
            root.left.next = root.right;
            if (root.next != null) {
                root.right.next = root.next.left;
            }
        }
        connect(root.left);
        connect(root.right);
        return root;
    }

    public TreeLinkNode connect3(TreeLinkNode root) {
        if (root == null) {
            return root;
        }
        TreeLinkNode start = root;
        while (start != null) {
            TreeLinkNode curr = start;
            while (curr != null) {
                if (curr.left != null) {
                    curr.left.next = curr.right;
                }
                if (curr.right != null && curr.next != null) {
                    curr.right.next = curr.next.left;
                }
                curr = curr.next;
            }
            start = start.left;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeLinkNode t1 = new TreeLinkNode(1);
        TreeLinkNode t2 = new TreeLinkNode(2);
        TreeLinkNode t3 = new TreeLinkNode(3);
        t1.left = t2;
        t1.right = t3;
        connect(t1);
        System.out.println("fuck");
    }
}
