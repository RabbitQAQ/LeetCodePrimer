package com.rabbit.solution.easy;

import com.rabbit.solution.utils.ListNode;

public class Solution141 {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(slow != null && fast != null) {
            if (fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) {
                    return true;
                }
            } else {
                return false;
            }
        }

        return false;
    }

    public static void main(String[] args) {

    }
}
