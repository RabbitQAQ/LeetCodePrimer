package com.rabbit.solution.easy;

import com.rabbit.solution.utils.ListNode;
import com.rabbit.solution.utils.Utils;

public class Solution206 {
    // Reverse Linked List
    // 遍历的方式
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }

    // 递归的方式
    public static ListNode reverseListRecursively(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode result = head;
        while (result.next != null) {
            result = result.next;
        }
        recursively(head);
        return result;
    }

    static ListNode recursively(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode temp = recursively(head.next);
        if (temp != null) {
            temp.next = head;
            head.next = null;
        }
        return head;
    }

    // 更好的递归做法  (C style)
//    class Solution {
//        public:
//        ListNode* reverseList(ListNode* head) {
//            if (!head || !head->next) return head;
//            ListNode *p = head;
//            head = reverseList(p->next);
//            p->next->next = p;
//            p->next = NULL;
//            return head;
//        }
//    };

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        Utils.printListNode(reverseListRecursively(listNode1));
    }
}
