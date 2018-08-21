package com.rabbit.solution.easy;

import java.util.Stack;

public class Solution155 {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(512);
        minStack.push(-1024);
        minStack.push(-1024);
        minStack.push(512);
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}

class MinStack {
    private Stack<Integer> normalStack;
    private Stack<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        normalStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        normalStack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    public void pop() {
        if (normalStack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        normalStack.pop();
    }

    public int top() {
        return normalStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
