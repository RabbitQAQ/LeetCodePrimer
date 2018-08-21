package com.rabbit.solution.easy;

public class Solution191 {
    public static int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            int t = n & 1;
            if (t == 1) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight(11));
    }
}
