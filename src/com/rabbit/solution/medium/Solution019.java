package com.rabbit.solution.medium;

import com.rabbit.solution.utils.ListNode;

import java.util.List;

public class Solution019 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode slow = dummyHead;
        ListNode fast = dummyHead;
        int count = 0;
        while(count <= n) {
            fast = fast.next;
            count++;
        }
        while(fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return dummyHead.next;
    }
}
