package com.rabbit.solution.easy;

import com.rabbit.solution.utils.ListNode;

public class Solution002 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode res = dummyHead;
        // Doesn't want to modify l1 and l2, make replica of them
        ListNode t1 = l1;
        ListNode t2 = l2;
        int carry = 0;
        // Traverse two listnode
        while(l1 != null || l2 != null) {
            int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
            carry = sum / 10;
            res.next = new ListNode(sum % 10);
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
            res = res.next;
        }

        if (carry == 1) {
            res.next = new ListNode(1);
        }

        return dummyHead.next;
    }
}
