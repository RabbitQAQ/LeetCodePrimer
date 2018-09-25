package com.rabbit.solution.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution017 {
    public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        List<String> two = new ArrayList<>(Arrays.asList("a", "b", "c"));
        List<String> three = new ArrayList<>(Arrays.asList("d", "e", "f"));
        List<String> four = new ArrayList<>(Arrays.asList("g", "h", "i"));
        List<String> five = new ArrayList<>(Arrays.asList("j", "k", "l"));
        List<String> six = new ArrayList<>(Arrays.asList("m", "n", "o"));
        List<String> seven = new ArrayList<>(Arrays.asList("p", "q", "r", "s"));
        List<String> eight = new ArrayList<>(Arrays.asList("t", "u", "v"));
        List<String> nine = new ArrayList<>(Arrays.asList("w", "x", "y", "z"));

        for (int i = 0; i < digits.length(); i++) {
            int digit = digits.charAt(i) - '0';
            switch (digit) {
                case 2:res = res.size() == 0 ? two : combine(res, two);break;
                case 3:res = res.size() == 0 ? three : combine(res, three);break;
                case 4:res = res.size() == 0 ? four : combine(res, four);break;
                case 5:res = res.size() == 0 ? five : combine(res, five);break;
                case 6:res = res.size() == 0 ? six : combine(res, six);break;
                case 7:res = res.size() == 0 ? seven : combine(res, seven);break;
                case 8:res = res.size() == 0 ? eight : combine(res, eight);break;
                case 9:res = res.size() == 0 ? nine : combine(res, nine);break;
                default:break;
            }
        }

        return res;
    }

    public static List<String> combine(List<String> s1, List<String> s2) {
        if (s1.size() == 0 || s2.size() == 0) {
            return s1.size() == 0 ? s2 : s1;
        }
        List<String> res = new ArrayList<>();
        for (String char1 : s1) {
            for (String char2 : s2) {
                res.add(char1 + char2);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
}
