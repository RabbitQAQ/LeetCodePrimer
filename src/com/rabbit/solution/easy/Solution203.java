package com.rabbit.solution.easy;

import com.rabbit.solution.utils.ListNode;

public class Solution203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode tmp = head;
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = tmp;
        ListNode prev = dummyHead;
        while (tmp != null) {
            if (tmp.val == val) {
                prev.next = tmp.next;
                tmp = tmp.next;
                continue;
            }
            prev = prev.next;
            tmp = tmp.next;
        }

        return dummyHead.next;
    }

    // 递归解法 非常简洁  边界条件也控制的很好  叹为观止
    public static ListNode removeElements2(ListNode head, int val) {
        if (head == null) return null;
        head.next = removeElements2(head.next, val);
        return head.val == val ? head.next : head;
    }

    public static void main(String[] args) {

    }
}
