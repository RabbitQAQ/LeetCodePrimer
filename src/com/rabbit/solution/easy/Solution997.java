package com.rabbit.solution.easy;

import java.util.HashSet;
import java.util.Set;

public class Solution997 {
    public int findJudge(int N, int[][] trust) {
        Set<Integer> set = new HashSet<>();
        int[] in = new int[N + 1];
        for (int i = 0; i < trust.length; i++) {
            set.add(trust[i][0]);
            in[trust[i][1]]++;
        }

        for (int i = 1; i < N + 1; i++) {
            if (in[i] == N - 1 && !set.contains(i)) {
                return i;
            }
        }

        return -1;
    }
}
