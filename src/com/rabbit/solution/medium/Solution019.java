package com.rabbit.solution.medium;

import com.rabbit.solution.utils.ListNode;

import java.util.List;

public class Solution019 {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode begin = reverseList(head);
        ListNode curr = begin;
        int count = 0;
        while (curr != null && count < n) {
            curr = curr.next;
            count++;
        }
        return reverseList(curr);
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode curr = head.next;
        ListNode prev = head;
        while (curr != null) {
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }

        return prev;
    }

    public static void main(String[] args) {
        ListNode test1 = new ListNode(1);
        ListNode test2 = new ListNode(2);
        ListNode test3 = new ListNode(3);
        ListNode test4 = new ListNode(4);
        ListNode test5 = new ListNode(5);
        test1.next = test2;
        test2.next = test3;
        test3.next = test4;
        test4.next = test5;

        ListNode head = removeNthFromEnd(test1, 2);
        System.out.println(head);
    }
}
