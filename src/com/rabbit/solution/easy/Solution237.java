package com.rabbit.solution.easy;

import com.rabbit.solution.easy.utils.ListNode;

public class Solution237 {
    public void deleteNode(ListNode node) {
        ListNode next = node.next;
        if (next != null) {
            node.val = next.val;
            node.next = next.next;
        } else {
            node = null;
        }
    }

    public static void main(String[] args) {

    }
}
