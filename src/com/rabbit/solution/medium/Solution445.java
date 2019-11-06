package com.rabbit.solution.medium;

import com.rabbit.solution.utils.ListNode;

import java.util.Stack;

public class Solution445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> nodeStack1 = new Stack<>();
        Stack<ListNode> nodeStack2 = new Stack<>();
        ListNode dummyNode = new ListNode(-1);
        while (l1 != null) {
            nodeStack1.push(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            nodeStack2.push(l2);
            l2 = l2.next;
        }
        Stack<ListNode> largerStack = nodeStack1.size() > nodeStack2.size() ? nodeStack1 : nodeStack2;
        Stack<ListNode> smallerStack = nodeStack1.size() > nodeStack2.size() ? nodeStack2 : nodeStack1;
        int carry = 0;
        while (!smallerStack.isEmpty() || !largerStack.isEmpty()) {
            ListNode lnode = largerStack.pop();
            ListNode snode = smallerStack.isEmpty() ? null : smallerStack.pop();
            lnode.val = lnode.val + (snode == null ? 0 : snode.val) + carry;
            carry = lnode.val / 10;
            lnode.val = lnode.val % 10;
            if (largerStack.isEmpty()) {
                dummyNode.next = lnode;
            }
        }
        if (carry > 0) {
            ListNode tmp = new ListNode(carry);
            tmp.next = dummyNode.next;
            dummyNode.next = tmp;
        }

        return dummyNode.next;
    }

    public static void main(String[] args) {

    }
}
