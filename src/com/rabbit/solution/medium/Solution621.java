package com.rabbit.solution.medium;

import java.util.Arrays;

public class Solution621 {
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            map[tasks[i] - 'A']++;
        }
        Arrays.sort(map);
        int maxNum = map[25];
        int i = 25;
        while (map[i] == maxNum) {
            i--;
        }
        return Math.max(tasks.length, (maxNum - 1) * (n + 1) + (25 - i));
    }
}
