package com.rabbit.solution.hard;

import com.rabbit.solution.utils.ListNode;
import com.rabbit.solution.utils.Utils;

public class Solution023 {
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        int n = lists.length;
        while (n > 1) {
            int j = (n + 1) / 2;
            for (int i = 0; i < n / 2; i++) {
                lists[i] = mergeList(lists[i], lists[i + j]);
            }
            n = j;
        }

        return lists[0];
    }

    public static ListNode mergeList(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(-1);
        ListNode curr = root;
        ListNode ptr1 = l1;
        ListNode ptr2 = l2;
        while (ptr1 != null && ptr2 != null) {
            if (ptr1.val < ptr2.val) {
                curr.next = ptr1;
                ptr1 = ptr1.next;
            } else {
                curr.next = ptr2;
                ptr2 = ptr2.next;
            }
            curr = curr.next;
        }

        if (ptr1 != null) {
            curr.next = ptr1;
        } else {
            curr.next = ptr2;
        }

        return root.next;
    }

    public static void main(String[] args) {
        ListNode test1 = new ListNode(1);
        ListNode test2 = new ListNode(4);
        ListNode test3 = new ListNode(7);
        ListNode test4 = new ListNode(2);
        ListNode test5 = new ListNode(5);
        ListNode test6 = new ListNode(8);
        ListNode test7 = new ListNode(3);
        ListNode test8 = new ListNode(6);
        ListNode test9 = new ListNode(9);
        test1.next = test2;
        test2.next = test3;
        test4.next = test5;
        test5.next = test6;
        test7.next = test8;
        test8.next = test9;

        ListNode[] test = new ListNode[3];
        test[0] = test1;
        test[1] = test4;
        test[2] = test7;

        Utils.printListNode(mergeKLists(test));
    }
}
