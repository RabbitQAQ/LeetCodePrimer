package com.rabbit.solution.easy;

public class Solution190 {
    public static int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int t = n & 1;
            if (t == 0) {
                result = result << 1;
            } else {
                result = result << 1;
                result++;
            }
            n = n >> 1;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(reverseBits(43261596));
    }
}
