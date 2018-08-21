package com.rabbit.solution.easy.utils;

public class Utils {
    public static void printListNode(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
    }
}
