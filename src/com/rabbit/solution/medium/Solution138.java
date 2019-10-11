package com.rabbit.solution.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution138 {
//    public Node copyRandomList(Node head) {
//        if (head == null) {
//            return head;
//        }
//        Map<Node, Node> map = new HashMap<>();
//        Node dummyHead = new Node();
//        Node ptr = dummyHead;
//        Node tmp = head;
//        while (tmp != null) {
//            Node newNode = new Node(tmp.val);
//            map.put(tmp, newNode);
//            tmp = tmp.next;
//            ptr.next = newNode;
//            ptr = ptr.next;
//        }
//        ptr = dummyHead.next;
//        tmp = head;
//        while (tmp != null) {
//            ptr.random = map.get(tmp.random);
//            ptr = ptr.next;
//            tmp = tmp.next;
//        }
//
//        return dummyHead.next;
//    }

//    public Node copyRandomList(Node head) {
//        Map<Node, Node> map = new HashMap<>();
//        Node tmp = head;
//        while (tmp != null) {
//            map.put(tmp, new Node(tmp.val, null, null));
//            tmp = tmp.next;
//        }
//        tmp = head;
//        while (tmp != null) {
//            Node curr = map.get(tmp);
//            curr.next = map.get(tmp.next);
//            curr.random = map.get(tmp.random);
//            tmp = tmp.next;
//        }
//
//        return map.get(head);
//    }

    public static void main(String[] args) {
        List<Integer> res = new ArrayList<>();
    }
}
