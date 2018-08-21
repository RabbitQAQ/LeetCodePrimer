package com.rabbit.solution.easy;

public class Solution020 {
    public static boolean isValid(String s) {
        if (s.isEmpty()) {
            return true;
        }

        String popStack = "";
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(' : popStack += '('; break;
                case '{' : popStack += '{'; break;
                case '[' : popStack += '['; break;
                case ')' : if (!popStack.isEmpty() && popStack.charAt(popStack.length() - 1) == '(') {
                    popStack = popStack.substring(0, popStack.length() - 1);
                } else {
                    return false;
                } break;
                case '}' : if (!popStack.isEmpty() && popStack.charAt(popStack.length() - 1) == '{') {
                    popStack = popStack.substring(0, popStack.length() - 1);
                } else {
                    return false;
                } break;
                case ']' : if (!popStack.isEmpty() && popStack.charAt(popStack.length() - 1) == '[') {
                    popStack = popStack.substring(0, popStack.length() - 1);
                } else {
                    return false;
                } break;
            }
        }

        if (popStack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(isValid("[()](())"));
    }
}
