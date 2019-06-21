package com.rabbit.solution.easy;

import com.rabbit.solution.utils.ListNode;
import com.rabbit.solution.utils.Utils;

public class Solution206 {
    // Reverse Linked List
    // 遍历的方式
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode res = head;
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }

        return prev;
    }

    // 递归的方式
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tmp = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return tmp;
    }

    // Archived Code
//    public static ListNode reverseListRecursively(ListNode head) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//        ListNode result = head;
//        while (result.next != null) {
//            result = result.next;
//        }
//        recursively(head);
//        return result;
//    }
//
//    static ListNode recursively(ListNode head) {
//        if (head == null) {
//            return null;
//        }
//        ListNode temp = recursively(head.next);
//        if (temp != null) {
//            temp.next = head;
//            head.next = null;
//        }
//        return head;
//    }
}
