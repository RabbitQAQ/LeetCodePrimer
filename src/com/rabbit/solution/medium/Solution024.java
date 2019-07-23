package com.rabbit.solution.medium;

import com.rabbit.solution.utils.ListNode;

public class Solution024 {
    // use pointers
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode slow = dummyHead;
        ListNode fast = dummyHead.next;
        while (fast != null && fast.next != null) {
            fast = fast.next;
            ListNode tmp = fast.next;
            fast.next = slow.next;
            slow.next = fast;
            fast.next.next = tmp;

            slow = slow.next.next;
            fast = tmp;
        }

        return dummyHead.next;
    }

    // recursively
    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tmp = head.next;
        head.next = swapPairs(head.next.next);
        tmp.next = head;

        return tmp;
    }
}
