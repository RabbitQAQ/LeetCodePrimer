package com.rabbit.solution.hard;

import com.rabbit.solution.utils.ListNode;
import com.rabbit.solution.utils.Utils;

import java.util.List;

public class Solution025 {
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1)
            return head;
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode start = dummyNode;
        ListNode follow = start.next;
        int i = 0;
        while (follow != null) {
            if (i == k) {
                i = 0;
                start = reverseInterval(start, follow);
            }
            i++;
            follow = follow.next;
        }

        return dummyNode.next;
    }

    private static ListNode reverseInterval(ListNode prev, ListNode follow) {
        ListNode last = prev.next;
        ListNode curr = last.next;
        while (curr != follow) {
            last.next = curr.next;
            curr.next = prev.next;
            prev.next = curr;
            curr = last.next;
        }
        return last;
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

        Utils.printListNode(reverseKGroup(test1, 2));
    }
}
