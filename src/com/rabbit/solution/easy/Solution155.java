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
