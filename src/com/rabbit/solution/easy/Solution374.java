package com.rabbit.solution.easy;

public class Solution374 {
    public static int guess(int num) {
        if (num > 6) {
            return 1;
        } else if (num < 6){
            return -1;
        } else {
            return 0;
        }
    }

    public static int guessNumber(int n) {
        int low = 1;
        int high = n;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if (guess(mid) == 0) {
                return mid;
            } else if (guess(mid) == 1) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(guessNumber(10));
    }
}
