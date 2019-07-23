package com.rabbit.solution.medium;

import com.rabbit.solution.utils.ListNode;

public class Solution086 {
    public ListNode partition(ListNode head, int x) {
        ListNode dummyHead1 = new ListNode(-1);
        ListNode dummyHead2 = new ListNode(-1);
        ListNode p1 = dummyHead1;
        ListNode p2 = dummyHead2;
        ListNode curr = head;
        while (curr != null) {
            if (curr.val >= x) {
                p2.next = curr;
                p2 = p2.next;
            } else {
                p1.next = curr;
                p1 = p1.next;
            }
            curr = curr.next;
        }
        p2.next = null;
        p1.next = dummyHead2.next;

        return dummyHead1.next;
    }
}
