package com.rabbit.solution.easy;

import java.util.HashSet;
import java.util.Set;

public class Solution575 {
    public int distributeCandies(int[] candies) {
        Set<Integer> hashset = new HashSet<>();
        for (int i: candies) {
            hashset.add(i);
        }
        return Math.min(hashset.size(), candies.length / 2);
    }
}
