package com.rabbit.solution.medium;

import java.util.Arrays;

public class Solution825 {
    // 利用了累加数组，比较快
    public int numFriendRequests2(int[] ages) {
        int[] sumArray = new int[121];
        int[] numArray = new int[121];
        for (int i = 0; i < ages.length; i++) {
            numArray[ages[i]] += 1;
        }
        for (int i = 1; i < sumArray.length; i++) {
            sumArray[i] = sumArray[i - 1] + numArray[i];
        }
        int res = 0;
        for (int i = 15; i < 121; i++) {
            if (numArray[i] == 0) {
                continue;
            } else {
                int count = sumArray[i] - sumArray[i / 2 + 7];
                res += count * numArray[i] - numArray[i];
            }
        }

        return res;
    }
    // brute force， 比较菜的解法
    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        int res = 0;
        for (int i = ages.length - 1; i >= 0; i--) {
            int lowerBound = ages[i] / 2 + 7;
            for (int j = i - 1; j >= 0; j--) {
                if (ages[j] > lowerBound) {
                    if (ages[j] == ages[i]) {
                        res++;
                    }
                    res++;
                } else {
                    break;
                }
            }
        }

        return res;
    }
}
