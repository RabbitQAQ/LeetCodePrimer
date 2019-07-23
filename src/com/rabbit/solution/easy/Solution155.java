package com.rabbit.solution.easy;

import java.util.Stack;

public class Solution155 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.pop();
    }
}

class MinStack {

    Stack<Integer> minStack;
    int minVal;

    /** initialize your data structure here. */
    public MinStack() {
        minStack = new Stack<Integer>();
        minVal = Integer.MAX_VALUE;
    }

    public void push(int x) {
        if (x <= minVal) {
            minStack.push(minVal);
            minVal = x;
        }
        minStack.push(x);
    }

    public void pop() {
        int top = minStack.pop();
        if (top == minVal) {
            minVal = minStack.pop();
        }
    }

    public int top() {
        return minStack.peek();
    }

    public int getMin() {
        return minVal;
    }
}

class MinStack2 {
    Stack<Integer> minStack;
    Stack<Integer> normalStack;

    /** initialize your data structure here. */
    public MinStack2() {
        minStack = new Stack<>();
        normalStack = new Stack<>();
    }

    public void push(int x) {
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
        normalStack.push(x);
    }

    public void pop() {
        int tmp = normalStack.pop();
        if (tmp == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return normalStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
