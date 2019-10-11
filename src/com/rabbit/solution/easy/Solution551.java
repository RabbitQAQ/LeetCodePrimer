package com.rabbit.solution.easy;

import java.util.HashMap;
import java.util.Map;

public class Solution551 {
    public boolean checkRecord(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                count++;
            } else if (i < s.length() - 2 && s.charAt(i) == 'L' && s.charAt(i + 1) == 'L' && s.charAt(i + 2) == 'L') {
                return false;
            }
        }
        Map<Integer, Integer> fuck = new HashMap<>();
        return count < 2;
    }
}
