package com.rabbit.solution.medium;

import com.rabbit.solution.utils.TreeLinkNode;

public class Solution117 {
    public TreeLinkNode connect(TreeLinkNode root) {
        if (root == null) {
            return root;
        }
        TreeLinkNode start = root;
        TreeLinkNode dummyNode = new TreeLinkNode();
        TreeLinkNode curr = dummyNode;
        while (start != null) {
            if (start.left != null) {
                curr.next = start.left;
                curr = curr.next;
            }
            if (start.right != null) {
                curr.next = start.right;
                curr = curr.next;
            }
            start = start.next;
            if (start == null) {
                curr = dummyNode;
                start = dummyNode.next;
                dummyNode.next = null;
            }
        }

        return root;
    }
}
