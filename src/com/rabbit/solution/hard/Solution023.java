package com.rabbit.solution.hard;

import com.rabbit.solution.utils.ListNode;
import com.rabbit.solution.utils.Utils;

import java.util.HashMap;
import java.util.Map;

public class Solution023 {

    // ver 2.0
    public ListNode mergeKLists2 (ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        } else if (lists.length == 1) {
            return lists[0];
        }
        int n = lists.length - 1;
        while (n > 0) {
            int left = 0;
            int right = n;
            while (left < right) {
                lists[left] = mergeTwoLists(lists[left], lists[right]);
                left++;
                right--;
            }
            n = right;
        }
        return lists[0];
    }

    public ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode tmp = dummyHead;
        ListNode p1 = head1;
        ListNode p2 = head2;
        while (p1 != null || p2 != null) {
            if (p2 == null ? true : p1 == null ? false : p1.val < p2.val) {
                tmp.next = p1;
                p1 = p1.next;
            } else {
                tmp.next = p2;
                p2 = p2.next;
            }
            tmp = tmp.next;
        }

        return dummyHead.next;
    }


    // ver 1.0
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
}
