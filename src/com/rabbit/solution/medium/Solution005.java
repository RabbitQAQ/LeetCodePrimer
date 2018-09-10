package com.rabbit.solution.medium;

public class Solution005 {
    // Manacher算法 详见http://www.cnblogs.com/grandyang/p/4475985.html
    public static String longestPalindrome(String s) {
        // prefix
        StringBuffer t = new StringBuffer();
        t.append("$#");
        for (int i = 0; i < s.length(); i++) {
            t.append(s.charAt(i));
            t.append("#");
        }
        t.append("¢");

        // calculate
        int mx = 0, id = 0, resMid = 0, resRadius = 0;
        int[] p = new int[t.length()];
        for (int i = 1; i < t.length() - 1; i++) {
            p[i] = mx > i ? Math.min(p[2 * id - i], mx - i) : 1;
            while (t.charAt(i + p[i]) == t.charAt(i - p[i])) {
                p[i]++;
            }
            if (mx < p[i]) {
                mx = p[i];
                id = i;
            }
            if (resRadius < p[i]) {
                resRadius = p[i];
                resMid = i;
            }
        }

        // return
        return t.substring(resMid - resRadius + 1, resMid + resRadius - 1).replace("#", "");
    }



    public static void main(String[] args) {
        System.out.println(longestPalindrome("abbbbbaab"));
    }
}
