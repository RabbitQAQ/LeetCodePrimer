package com.rabbit.solution.easy;

public class Solution844 {
    public boolean backspaceCompare(String S, String T) {
        StringBuilder sb = new StringBuilder();
        StringBuilder tb = new StringBuilder();
        buildString(sb, S);
        buildString(tb, T);
        return sb.toString().equals(tb.toString());
    }

    public void buildString(StringBuilder sb, String s) {
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr == '#') {
                if (sb.length() == 0) {
                    continue;
                } else {
                    sb.deleteCharAt(sb.length() - 1);
                }
            } else {
                sb.append(curr);
            }
        }
    }
}
