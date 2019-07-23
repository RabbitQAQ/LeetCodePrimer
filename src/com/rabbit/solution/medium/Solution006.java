package com.rabbit.solution.medium;

import java.util.ArrayList;
import java.util.List;

public class Solution006 {
    // better for understanding
    public String convert2(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        List<StringBuilder> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            res.add(new StringBuilder());
        }
        int count = 0;
        int step = 1;
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            res.get(count).append(curr);
            if (count == numRows - 1) {
                step = -1;
            }
            if (count == 0) {
                step = 1;
            }
            count += step;
        }

        StringBuilder strRes = new StringBuilder();
        for (int i = 0; i < res.size(); i++) {
            strRes.append(res.get(i));
        }
        return strRes.toString();
    }

    // clumsy idea
    public String convert(String s, int numRows) {
        if (s.length() < numRows || numRows == 1) {
            return s;
        }
        List<List<Character>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            res.add(new ArrayList<>());
        }

        int n = numRows + (numRows - 2);
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if ((i % n) > numRows - 1 && (i % n) < n) {
                // zigzag
                res.get(2 * (numRows - 1) - (i % n)).add(curr);
            } else {
                // normal
                res.get(i % n).add(curr);
            }
        }

        StringBuffer strRes = new StringBuffer();
        for (int i = 0; i < res.size(); i++) {
            List<Character> tmp = res.get(i);
            for (int j = 0; j < tmp.size(); j++) {
                strRes.append(tmp.get(j));
            }
        }

        return strRes.toString();
    }

}
