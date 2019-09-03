package com.rabbit.solution.medium;

import java.util.Stack;

public class Solution426 {
//    Node prev;
//    Node head;
//
//    public Node treeToDoublyList3(Node root) {
//        if (root == null) {
//            return null;
//        }
//        Stack<Node> stack = new Stack<>();
//        Node head = null;
//        Node prev = null;
//        Node tmp = root;
//        while (tmp != null || !stack.isEmpty()) {
//            while (tmp != null) {
//                stack.push(tmp);
//                tmp = tmp.left;
//            }
//            tmp = stack.pop();
//            if (head == null) {
//                head = tmp;
//            }
//            if (prev != null) {
//                prev.right = tmp;
//                tmp.left = prev;
//            }
//            prev = tmp;
//            tmp = tmp.right;
//        }
//
//        head.left = prev;
//        prev.right = head;
//
//        return head;
//    }
//
//    public Node treeToDoublyList2(Node root) {
//        if (root == null) {
//            return null;
//        }
//        Stack<Node> stack = new Stack<>();
//        Node head = null;
//        Node tail = null;
//        Node tmp = root;
//        while (tmp != null) {
//            stack.push(tmp);
//            tmp = tmp.left;
//        }
//        Node prev = null;
//        while (!stack.isEmpty()) {
//            Node curr = stack.pop();
//            tmp = curr.right;
//            while (tmp != null) {
//                stack.push(tmp);
//                tmp = tmp.left;
//            }
//            if (stack.isEmpty()) {
//                tail = curr;
//            }
//            if (prev == null) {
//                head = curr;
//            } else {
//                prev.right = curr;
//                curr.left = prev;
//            }
//            prev = curr;
//
//        }
//
//        head.left = tail;
//        tail.right = head;
//
//        return head;
//    }
//
//    public Node treeToDoublyList(Node root) {
//        if (root == null) {
//            return null;
//        }
//        helper(root);
//        head.left = prev;
//        prev.right = head;
//        return head;
//    }
//
//    public void helper(Node root) {
//        if (root == null) {
//            return;
//        }
//        helper(root.left);
//        if (this.prev == null) {
//            this.head = root;
//        } else {
//            this.prev.right = root;
//            root.left = this.prev;
//        }
//        this.prev = root;
//        helper(root.right);
//    }
}
