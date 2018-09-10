package com.rabbit.solution.easy;


import com.rabbit.solution.utils.ListNode;

public class Solution021 {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode root = l1;
        ListNode prev = null;
        ListNode l2Temp = l2;
        do {
            if (l2 == null) {
                break;
            }
            if (l1.val > l2.val) {
                if (prev == null) {
                    l2Temp = l2.next;
                    l2.next = l1;
                    prev = l2;
                    root = l2;
                    l2 = l2Temp;
                } else {
                    l2Temp = l2.next;
                    prev.next = l2;
                    l2.next = l1;
                    prev = l2;
                    l2 = l2Temp;
                }
            } else {
                prev = l1;
                l1 = l1.next;
            }
        }
        while (l1 != null);

        if (l2 != null) {
            prev.next = l2;
        }

        return root;
    }

    public static void main(String[] args) {
        ListNode ln1 = new ListNode(1);
        ListNode ln2 = new ListNode(2);
        ListNode ln3 = new ListNode(4);
        ListNode ln4 = new ListNode(5);
        ListNode ln5 = new ListNode(3);
        ListNode ln6 = new ListNode(4);

        ln1.next = ln2;
        ln2.next = ln3;
//        ln4.next = ln5;
//        ln5.next = ln6;

        ListNode root = mergeTwoLists(ln4, ln1);
        while (root != null) {
            System.out.print(root);
            root = root.next;
        }
    }
}
