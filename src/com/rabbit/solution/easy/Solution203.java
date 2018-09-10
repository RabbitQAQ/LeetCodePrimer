package com.rabbit.solution.easy;

import com.rabbit.solution.utils.ListNode;

public class Solution203 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        ListNode result = head;
        ListNode prev = head;
        ListNode curr = head;
        while (curr != null) {
            if (prev == curr) {
                if (prev.val == val) {
                    result = curr.next;
                    prev = curr.next;
                    curr = curr.next;
                } else {
                    curr = curr.next;
                }
                continue;
            }

            if (curr.val == val) {
                prev.next = curr.next;
                curr = curr.next;
            } else {
                prev = curr;
                curr = curr.next;
            }

        }

        return result;
    }

    // 递归解法 非常简洁  边界条件也控制的很好  叹为观止
    public static ListNode removeElements2(ListNode head, int val) {
        if (head == null) return null;
        head.next = removeElements2(head.next, val);
        return head.val == val ? head.next : head;
    }

    public static void main(String[] args) {

    }
}
