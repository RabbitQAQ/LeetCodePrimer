package com.rabbit.solution.others;

import java.util.*;
public class SolutionYouZan2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(getResultString(str));
    }

    public static String getResultString(String s) {
        if (s.length() < 2) {
            return s;
        }
        int max = 0;
        String res = "";
        for (int i = 0; i < s.length(); ) {
            // not possible any more, just break to reduce time complexity
            if (s.length() - i <= max / 2) {
                break;
            }
            // jump through same word
            int left = i;
            int right = i;
            while (right < s.length() - 1 && s.charAt(right) == s.charAt(right + 1)) {
                right++;
            }
            i = right + 1;
            while (left > 0 && right < s.length() - 1 && s.charAt(left - 1) == s.charAt(right + 1)) {
                left--;
                right++;
            }
            if (right - left + 1 > max) {
                max = right - left + 1;
                res = s.substring(left, right + 1);
            }
        }

        return res;
    }
}
