package com.rabbit.solution.medium;

import java.util.Stack;

public class Solution150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (tokens[i].equals("-")) {
                int t1 = stack.pop();
                int t2 = stack.pop();
                stack.push(t2 - t1);
            } else if (tokens[i].equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (tokens[i].equals("/")) {
                int t1 = stack.pop();
                int t2 = stack.pop();
                stack.push(t2 / t1);
            } else {
                stack.push(Integer.valueOf(tokens[i]));
            }
        }

        return stack.pop();
    }
}
