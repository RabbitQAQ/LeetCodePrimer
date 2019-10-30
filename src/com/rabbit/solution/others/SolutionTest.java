package com.rabbit.solution.others;

import com.rabbit.solution.utils.ListNode;

import java.util.*;


public class SolutionTest {

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode begin;
        if (head==null || head.next ==null || k==1)
            return head;
        ListNode dummyhead = new ListNode(-1);
        dummyhead.next = head;
        begin = dummyhead;
        int i=0;
        while (head != null){
            i++;
            if (i%k == 0){
                begin = reverse(begin, head.next);
                head = begin.next;
            } else {
                head = head.next;
            }
        }
        return dummyhead.next;

    }

    public static ListNode reverse(ListNode begin, ListNode end){
        ListNode curr = begin.next;
        ListNode next, first;
        ListNode prev = begin;
        first = curr;
        while (curr!=end){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        begin.next = prev;
        first.next = curr;
        return first;
    }

    public static void main(String[] args) {
        ListNode t1 = new ListNode(0);
        ListNode t2 = new ListNode(1);
        ListNode t3 = new ListNode(2);
        ListNode t4 = new ListNode(3);
        ListNode t5 = new ListNode(4);
        t1.next = t2;
        t2.next = t3;
        t3.next = t4;
        t4.next = t5;
        ListNode res = reverseKGroup(t1, 2);
        System.out.println(res);
    }
}
