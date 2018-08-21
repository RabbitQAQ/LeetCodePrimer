package com.rabbit.solution.easy;

public class Solution014 {
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String shortest = strs[0];
        String result = "";
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < shortest.length()) {
                shortest = strs[i];
            }
        }
        for (int i = 0; i < shortest.length(); i++) {
            boolean flag = true;
            for (int j = 0; j < strs.length; j++) {
                if (shortest.charAt(i) == strs[j].charAt(i)) {
                    continue;
                } else {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result += shortest.charAt(i);
                continue;
            } else {
                return result;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String[] testStr = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(testStr));
    }
}
