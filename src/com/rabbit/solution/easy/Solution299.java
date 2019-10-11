package com.rabbit.solution.easy;

import java.util.HashMap;
import java.util.Map;

public class Solution299 {

    // one pass
    public String getHint2(String secret, String guess) {
        int[] map = new int[10];
        int countA = 0;
        int countB = 0;
        for (int i = 0; i < secret.length(); i++) {
            int currS = secret.charAt(i) - '0';
            int currG = guess.charAt(i) - '0';
            if (currS == currG) {
                countA++;
            } else {
                if (map[currS] < 0) {
                    countB++;
                }
                if (map[currG] > 0) {
                    countB++;
                }
                map[currS]++;
                map[currG]--;
            }
        }

        return String.valueOf(countA) + "A" + String.valueOf(countB) + "B";
    }


    public String getHint(String secret, String guess) {
        Map<Character, Integer> map = new HashMap<>();
        int countA = 0;
        int countB = 0;
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                countA++;
            } else {
                map.put(secret.charAt(i), map.getOrDefault(secret.charAt(i), 0) + 1);
            }
        }
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) != guess.charAt(i)) {
                if (map.getOrDefault(guess.charAt(i), 0) != 0) {
                    countB++;
                    map.put(guess.charAt(i), map.get(guess.charAt(i)) - 1);
                }
            }
        }
        return String.valueOf(countA) + "A" + String.valueOf(countB) + "B";
    }
}
