package com.rabbit.solution.medium;

import java.util.Stack;

public class Solution388 {
    public int lengthLongestPath(String input) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        String[] strs = input.split("\n");
        int maxLen = 0;
        for (int i = 0; i < strs.length; i++) {
            int numOfT = strs[i].lastIndexOf("\t") + 1;
            int level = numOfT + 1;
            while (level < stack.size()) {
                stack.pop();
            }
            int currLen = stack.peek() + strs[i].length() - numOfT + 1;
            stack.push(currLen);
            if (strs[i].contains(".")) {
                maxLen = Math.max(maxLen, currLen - 1);
            }
        }

        return maxLen;
    }
}
