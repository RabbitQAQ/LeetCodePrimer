package com.rabbit.solution.medium;

import com.rabbit.solution.utils.ListNode;

public class Solution328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            ListNode tmp = slow.next;
            slow.next = fast.next;
            fast.next = fast.next.next;
            slow.next.next = tmp;
            slow = slow.next;
            fast = fast.next;
        }

        return head;
    }
}
