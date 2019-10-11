package com.rabbit.solution.medium;

import java.util.HashMap;
import java.util.Map;

public class Solution957 {
    public int[] prisonAfterNDays(int[] cells, int N) {
        Map<String, Integer> map = new HashMap<>();
        StringBuilder state = new StringBuilder();
        for (int i = 0; i < cells.length; i++) {
            if (cells[i] == 0) {
                state.append("0");
            } else {
                state.append("1");
            }
        }

        while (N > 0) {
            if (map.containsKey(state.toString())) {
                N %= map.get(state.toString()) - N;
            }
            map.put(state.toString(), N);
            if (N >= 1) {
                N--;
                state = nextDay(state);
            }
        }

        int[] res = new int[8];
        for (int i = 0; i < state.length(); i++) {
            if (state.charAt(i) == '0') {
                res[i] = 0;
            } else {
                res[i] = 1;
            }
        }
        return res;
    }

    public StringBuilder nextDay(StringBuilder state) {
        StringBuilder newDay = new StringBuilder();
        newDay.append("0");
        for (int i = 1; i < 7; i++) {
            if (state.charAt(i - 1) == state.charAt(i + 1)) {
                newDay.append("1");
            } else {
                newDay.append("0");
            }
        }
        newDay.append("0");
        return newDay;
    }
}
