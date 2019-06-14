package com.rabbit.solution.easy;

public class Solution482 {
    public static String licenseKeyFormatting(String S, int K) {
        String res = "";
        S = S.replace("-", "").toUpperCase();
        int i = S.length();
        for (; i > K; i -= K) {
            res = "-" + S.substring(i - K, i) + res;
        }
        res = S.substring(0, i) + res;

        return res;
    }

    public static String solution(String S, int K) {
        // write your code in Java SE 8
        StringBuilder res = new StringBuilder(S.replace("-", "").toUpperCase());
        for (int i = res.length() - 1; i > 0;) {
            i -= 4;
            if (i <= 0) break;
            else {
                res.insert(i, "-");
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("2-4A0r7-4k", 4));
        //System.out.println(licenseKeyFormatting("2-5g-3-J", 2));
//        String s = "sdadsa";
//        s = s.replace("s", "a").toUpperCase();
//
//        StringBuilder res = new StringBuilder("fuck");
//        res.append("wow");
//        res.insert(0, "-");
//        System.out.println(res);
    }
}
