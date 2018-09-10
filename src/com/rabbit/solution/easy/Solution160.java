package com.rabbit.solution.easy;

import com.rabbit.solution.utils.ListNode;

public class Solution160 {
    // 巧妙的解法  先遍历链表获取长度  然后将长的那个链表初始节点向后推差值的长度即可
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode rootA = headA;
        ListNode rootB = headB;
        int countA = 0;
        int countB = 0;
        while (headA != null) {
            countA++;
            headA = headA.next;
        }
        while (headB != null) {
            countB++;
            headB = headB.next;
        }

        int diff = 0;
        if (countA > countB) {
            diff = countA - countB;
            while (diff > 0) {
                rootA = rootA.next;
                diff--;
            }
        } else {
            diff = countB - countA;
            while (diff > 0) {
                rootB = rootB.next;
                diff--;
            }
        }

        while (rootA != null && rootB != null) {
            if (rootA == rootB) {
                return rootA;
            }
            rootA = rootA.next;
            rootB = rootB.next;
        }

        return null;
    }

    public static void main(String[] args) {

    }
}
