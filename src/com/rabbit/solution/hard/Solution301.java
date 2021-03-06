package com.rabbit.solution.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution301 {
    public List<String> removeInvalidParentheses2(String s) {
        List<String> res = new ArrayList<>();
        helper(s, new char[] {'(', ')'}, 0, 0, res);
        return res;
    }

    public void helper(String s, char[] par, int lasti, int lastj, List<String> res) {
        int count = 0;
        for (int i = lasti; i < s.length(); i++) {
            if (s.charAt(i) == par[0]) {
                count++;
            } else if (s.charAt(i) == par[1]) {
                count--;
            }
            if (count >= 0) {
                continue;
            }
            for (int j = lastj; j < s.length(); j++) {
                if (s.charAt(j) == par[1] && (j == lastj || s.charAt(j - 1) != s.charAt(j))) {
                    helper(s.substring(0, j) + s.substring(j + 1), par, i, j, res);
                }
            }
            return;
        }
        String rev = new StringBuilder(s).reverse().toString();
        if (par[0] == '(') {
            helper(rev, new char[] {')', '('}, 0, 0, res);
        } else {
            res.add(rev);
        }
    }


    public static List<String> removeInvalidParentheses(String s) {
        int cntLeft = 0, cntRight = 0;
        for (int i = 0; i < s.length(); i++) {
            cntLeft += s.charAt(i) == '(' ? 1 : 0;
            if (cntLeft == 0)
                cntRight += s.charAt(i) == ')' ? 1 : 0;
            else
                cntLeft -= s.charAt(i) == ')' ? 1 : 0;
        }
        List<String> res = new ArrayList<>();
        goRecursively(s, 0, cntLeft, cntRight, res);
        return res;
    }

    public static void goRecursively(String s, int index, int cntLeft, int cntRight, List<String> res) {
        if (cntLeft == 0 && cntRight == 0) {
            if (isValid(s))
                res.add(s);
            return;
        }

        for (int i = index; i < s.length(); i++) {
            if (i != index && s.charAt(i) == s.charAt(i - 1))
                continue;
            if (cntLeft > 0 && s.charAt(i) == '(') {
                goRecursively(s.substring(0, i) + s.substring(i + 1), i, cntLeft - 1, cntRight, res);
            }
            if (cntRight >0 && s.charAt(i) == ')') {
                goRecursively(s.substring(0, i) + s.substring(i + 1), i, cntLeft, cntRight - 1, res);
            }
        }

    }

    public static boolean isValid(String s) {
        if (s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
            } else if (s.charAt(i) == ')') {
                if (stack.empty())
                    return false;
                else stack.pop();
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(removeInvalidParentheses(")o(v("));
    }
}
