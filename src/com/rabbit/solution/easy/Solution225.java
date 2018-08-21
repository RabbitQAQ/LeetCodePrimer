package com.rabbit.solution.easy;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Solution225 {
    static class MyStack {
        Queue<Integer> queue;
        Queue<Integer> tmp;
        /** Initialize your data structure here. */
        public MyStack() {
            queue = new LinkedList<>();
            tmp = new LinkedList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            tmp.add(x);
            tmp.addAll(queue);
            queue = tmp;
            tmp = new LinkedList<>();
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            return queue.poll();
        }

        /** Get the top element. */
        public int top() {
            return queue.peek();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return queue.isEmpty();
        }
    }

    public static void main(String[] args) {
        MyStack ms = new MyStack();
        ms.push(1);
        ms.push(2);
        System.out.println(ms.top());
        System.out.println(ms.pop());
        System.out.println(ms.empty());
    }
}
