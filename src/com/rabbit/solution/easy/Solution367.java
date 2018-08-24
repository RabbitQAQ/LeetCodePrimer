package com.rabbit.solution.easy;

public class Solution367 {
    public boolean isPerfectSquare(int num) {
        for (int i = 1; i <= num / i; i++) {
            if (i * i == num) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

    }
}
