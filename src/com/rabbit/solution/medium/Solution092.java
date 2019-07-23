package com.rabbit.solution.medium;

import com.rabbit.solution.utils.ListNode;

public class Solution092 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode startNode = dummyHead;
        ListNode endNode = dummyHead;
        int count = 0;
        while (count < m - 1) {
            startNode = startNode.next;
            count++;
        }
        count = 0;
        while (count < n + 1) {
            endNode = endNode.next;
            count++;
        }
        ListNode endOfReversedList = startNode.next;
        ListNode prev = startNode.next;
        ListNode curr = startNode.next.next;
        while (curr != endNode) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        endOfReversedList.next = endNode;
        startNode.next = prev;

        return dummyHead.next;
    }
}
