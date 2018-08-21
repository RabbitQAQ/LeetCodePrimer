package com.rabbit.solution.easy;

public class Solution205 {
    public static boolean isIsomorphic(String s, String t) {
        // 数组代替哈希表  因为ASCII码一共只有256个
        int[] hash1 = new int[256];
        int[] hash2 = new int[256];
        for (int i = 0; i < t.length(); i++) {
            if (hash1[s.charAt(i)] != hash2[t.charAt(i)]) {
                return false;
            }
            hash1[s.charAt(i)] = i + 1;
            hash2[t.charAt(i)] = i + 1;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("paper", "titll"));
    }
}
