package com.rabbit.solution.easy;

import com.rabbit.solution.utils.ListNode;

public class Solution083 {
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode root = head;
        ListNode prev = null;
        while (head != null) {
            if (prev != null) {
                while (head != null && prev.val == head.val) {
                    head = head.next;
                }
                prev.next = head;
                prev = head;
                if (head != null) {
                    head = head.next;
                }
            } else {
                prev = head;
                head = head.next;
            }
        }

        return root;
    }

    public static void main(String[] args) {

    }
}
