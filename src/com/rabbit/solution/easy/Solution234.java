package com.rabbit.solution.easy;

import com.rabbit.solution.easy.utils.ListNode;

import java.util.Stack;

public class Solution234 {
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        Stack<Integer> stack = new Stack<>();
        while (fast != null) {
            if (fast.next != null) {
                stack.push(slow.val);
                fast = fast.next.next;
                slow = slow.next;
            } else {
                slow = slow.next;
                break;
            }
        }

        while (slow != null) {
            if (slow.val != stack.pop()) {
                return false;
            }
            slow = slow.next;
        }

        return true;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(1);
        listNode1.next = listNode2;
        listNode2.next = listNode3;

        System.out.println(isPalindrome(listNode1));
    }
}
