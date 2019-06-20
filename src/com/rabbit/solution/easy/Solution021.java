package com.rabbit.solution.easy;


import com.rabbit.solution.utils.ListNode;

import java.util.List;

public class Solution021 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode curr = new ListNode(-1);
        ListNode dummyHead = curr;
        ListNode t1 = l1;
        ListNode t2 = l2;
        while (t1 != null || t2 != null) {
            if ((t1 == null ? true : (t2 == null ? false : t1.val > t2.val))) {
                curr.next = t2;
                t2 = t2.next;
                curr = curr.next;
            } else {
                curr.next = t1;
                t1 = t1.next;
                curr = curr.next;
            }
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {

    }
}
