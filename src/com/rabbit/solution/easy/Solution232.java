package com.rabbit.solution.easy;

import java.util.Stack;

public class Solution232 {
    class MyQueue {
        Stack<Integer> mainStack;
        Stack<Integer> helperStack;
        /** Initialize your data structure here. */
        public MyQueue() {
            mainStack = new Stack<>();
            helperStack = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            while(!mainStack.isEmpty()) {
                helperStack.push(mainStack.pop());
            }
            helperStack.push(x);
            while(!helperStack.isEmpty()) {
                mainStack.push(helperStack.pop());
            }
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            return mainStack.pop();
        }

        /** Get the front element. */
        public int peek() {
            return mainStack.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return mainStack.isEmpty();
        }
    }

    class MyQueue2 {
        Stack<Integer> mainStack;
        Stack<Integer> helperStack;
        /** Initialize your data structure here. */
        public MyQueue2() {
            mainStack = new Stack<>();
            helperStack = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            mainStack.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if (helperStack.isEmpty()) {
                while (!mainStack.isEmpty()) {
                    helperStack.push(mainStack.pop());
                }
            }
            return helperStack.pop();
        }

        /** Get the front element. */
        public int peek() {
            if (helperStack.isEmpty()) {
                while (!mainStack.isEmpty()) {
                    helperStack.push(mainStack.pop());
                }
            }
            return helperStack.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return mainStack.isEmpty() && helperStack.isEmpty();
        }
    }
}
