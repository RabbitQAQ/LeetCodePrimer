package com.rabbit.solution.easy;

import java.util.Stack;

public class Solution020 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);
            if (tmp == '(' || tmp == '[' || tmp == '{') {
                stack.push(tmp);
                continue;
            }
            if (stack.isEmpty())
                return false;
            char top = stack.pop();
            if ((tmp == ')' && top != '(') ||(tmp == ']' && top != '[') || (tmp == '}' && top != '{') ) {
                return false;
            }
        }

        return stack.isEmpty();
    }

}
