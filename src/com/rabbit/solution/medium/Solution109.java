package com.rabbit.solution.medium;

import com.rabbit.solution.utils.ListNode;
import com.rabbit.solution.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution109 {
    public TreeNode sortedListToBST2(ListNode head) {
        List<Integer> values = new ArrayList<>();
        while (head != null) {
            values.add(head.val);
            head = head.next;
        }
        TreeNode res = formBST(values, 0, values.size() - 1);
        return formBST(values, 0, values.size() - 1);
    }

    public TreeNode formBST(List<Integer> values, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode res = new TreeNode(values.get(mid));
        res.left = formBST(values, left, mid - 1);
        res.right = formBST(values, mid + 1, right);
        return res;
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode middle = findMiddle(head);
        TreeNode root = new TreeNode(middle.val);
        if (middle == head) {
            root.right = sortedListToBST(middle.next);
        } else {
            root.left = sortedListToBST(head);
            root.right = sortedListToBST(middle.next);
        }


        return root;
    }

    public ListNode findMiddle(ListNode head) {
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if (prev != null) {
            prev.next = null;
        }

        return slow;
    }
}
