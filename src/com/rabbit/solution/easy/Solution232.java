package com.rabbit.solution.easy;

import java.util.Stack;

public class Solution232 {
    class MyQueue {
        Stack<Integer> stack;
        Stack<Integer> tmp;
        /** Initialize your data structure here. */
        public MyQueue() {
            stack = new Stack<>();
            tmp = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            tmp.push(x);
            tmp.addAll(stack);
            stack = tmp;
            tmp = new Stack<>();
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            return stack.pop();
        }

        /** Get the front element. */
        public int peek() {
            return stack.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return stack.isEmpty();
        }
    }

    public static void main(String[] args) {

    }
}
