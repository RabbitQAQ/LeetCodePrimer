package com.rabbit.solution.easy;

import com.rabbit.solution.easy.utils.ListNode;

public class Solution002 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = l1;
        ListNode prev = null;
        int flag = 0;
        while (l1 != null) {
            if (l2 == null) {
                int sum3 = l1.val + flag;
                if (sum3 >= 10) {
                    flag = 1;
                } else {
                    flag = 0;
                }
                l1.val = sum3 % 10;
                prev = l1;
                l1 = l1.next;
                continue;
            }

            int sum = l1.val + l2.val + flag;
            if (sum >= 10) {
                flag = 1;
            } else {
                flag = 0;
            }

            l1.val = sum % 10;

            if (l1.next == null) {
                l1.next = l2.next;
                prev = l1;
                l1 = l1.next;
                while (l1 != null) {
                    int sum2 = l1.val + flag;
                    if (sum2 >= 10) {
                        flag = 1;
                    } else {
                        flag = 0;
                    }
                    l1.val = sum2 % 10;
                    prev = l1;
                    l1 = l1.next;
                }
            } else {
                prev = l1;
                l1 = l1.next;
                l2 = l2.next;
            }

        }

        if (flag == 1) {
            prev.next = new ListNode(1);
        }

        return root;
    }

    // 一个值得参考的简洁解法 非常棒
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode prev = new ListNode(0);
        ListNode head = prev;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            ListNode cur = new ListNode(0);
            int sum = ((l2 == null) ? 0 : l2.val) + ((l1 == null) ? 0 : l1.val) + carry;
            cur.val = sum % 10;
            carry = sum / 10;
            prev.next = cur;
            prev = cur;

            l1 = (l1 == null) ? l1 : l1.next;
            l2 = (l2 == null) ? l2 : l2.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode t1 = new ListNode(1);
        ListNode t2 = new ListNode(9);
        ListNode t3 = new ListNode(9);
        t2.next = t3;

        System.out.println(addTwoNumbers(t1, t2));
    }
}
