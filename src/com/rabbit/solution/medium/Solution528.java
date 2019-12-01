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
            // 注意区间开闭 从[0~最后一个数)
            // 这也是为什么这种解法能够成立
            // 考虑[1,2]的例子，0，1，2中0属于1，而1和2都属于2，所以是找到第一个大于mid的数的index
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
