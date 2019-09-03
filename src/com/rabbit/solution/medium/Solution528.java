package com.rabbit.solution.medium;

import java.util.Random;

public class Solution528 {
    class Solution {

        Random rand = new Random();
        int[] sum;

        public Solution(int[] w) {
            sum = new int[w.length];
            sum[0] = w[0];
            for (int i = 1; i < w.length; i++) {
                sum[i] = sum[i - 1] + w[i];
            }
        }

        public int pickIndex() {
            int randNum = rand.nextInt(sum[sum.length - 1]);
            int left = 0;
            int right = sum.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (sum[mid] <= randNum) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            return left;
        }

    }
}
