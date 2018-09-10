package com.rabbit.solution.utils;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }

    @Override
    public String toString() {
        if (next != null) {
            return val + " -> ";
        } else
            return String.valueOf(val);

    }
}
