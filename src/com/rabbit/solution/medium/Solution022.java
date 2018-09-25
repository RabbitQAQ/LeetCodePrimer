package com.rabbit.solution.medium;

import java.util.ArrayList;
import java.util.List;

public class Solution022 {
    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generate(n, n, "", res);
        return res;
    }

    public static void generate(int left, int right, String str, List<String> res) {
        if (left > right) return;
        if (left == 0 && right == 0) {
            res.add(str);
        } else {
            if (left > 0) generate(left - 1, right, str + "(", res);
            if (right > 0) generate(left, right - 1, str + ")", res);
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}
