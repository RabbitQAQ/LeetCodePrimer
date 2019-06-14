package com.rabbit.solution.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution403 {
    public static boolean canCross(int[] stones) {
        Map<Integer, Set<Integer>> resMap = new HashMap<>();
        int[] dp = new int[stones.length];
        dp[0] = 0;
        Set<Integer> initSet = new HashSet<>();
        initSet.add(0);
        resMap.put(0, initSet);
        for (int i = 1; i < stones.length; i++) {
            for (int k = 0; k < i; k++) {
                int dist = stones[i] - stones[k];
                if (dist > dp[k] + 1) {
                    continue;
                }
                if (resMap.containsKey(k) && (resMap.get(k).contains(dist - 1) || resMap.get(k).contains(dist) || resMap.get(k).contains(dist + 1))) {
                    if (resMap.containsKey(i)) {
                        resMap.get(i).add(dist);
                    } else {
                        Set<Integer> tmp = new HashSet<>();
                        tmp.add(dist);
                        resMap.put(i, tmp);
                    }
                    dp[i] = Math.max(dp[i], dist);
                }
            }
        }

        return dp[stones.length - 1] != 0;
    }

    public static void main(String[] args) {
        int[] testcase = {0,1,3,5,6,8,12,17};
        System.out.println(canCross(testcase));
    }
}
