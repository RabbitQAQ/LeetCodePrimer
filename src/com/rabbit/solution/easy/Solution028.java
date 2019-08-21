package com.rabbit.solution.easy;

public class Solution028 {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        } else if (needle.length() > haystack.length()) {
            return -1;
        }
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            int j = 0;
            while (i + j < haystack.length() && j < needle.length() && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }
            if (j == needle.length()) {
                return i;
            }
        }

        return -1;
    }

    public int strStr2(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        } else if (needle.length() > haystack.length()) {
            return -1;
        }
        int[] next = getNext(needle);
        for (int i = 0; i < next.length; i++) {
            System.out.println(next[i]);
        }
        int i = 0;
        int j = 0;
        while (i < haystack.length() && j < needle.length()) {
            if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
                j++;
                i++;
            } else {
                j = next[j];
            }
        }
        return j == needle.length() ? i - j : -1;
    }

    public int[] getNext(String needle) {
        int[] next = new int[needle.length()];
        next[0] = -1;
        int j = 0;
        int k = -1;
        while (j < needle.length() - 1) {
            if (k == -1 || needle.charAt(k) == needle.charAt(j)) {
                k++;
                j++;
                next[j] = k;
            } else {
                k = next[k];
            }
        }

        return next;
    }
}
