package com.rabbit.solution.easy;

public class Solution028 {
    public static int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }

        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                if (haystack.length() - i < needle.length()) {
                    return -1;
                }
                boolean isSame = true;
                for (int j = 0; j < needle.length(); j++) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        isSame = false;
                    }
                }

                if (isSame) {
                    return i;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String hayStack = "aaa", needle = "aaaa";

        System.out.println(strStr(hayStack, needle));
    }
}
