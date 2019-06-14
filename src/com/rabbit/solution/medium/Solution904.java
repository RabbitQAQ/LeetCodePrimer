package com.rabbit.solution.medium;

import java.util.*;

public class Solution904 {
    public static int totalFruit(int[] tree) {
        //Sliding Window
        Map<Integer, Integer> fruitNow = new HashMap<>();
        int leftPos = 0;
        int rightPos = 0;
        int res = 0;
        int currRes = 0;
        for (int i = 0; i < tree.length; i++) {
            if (fruitNow.size() == 2 && !fruitNow.containsKey(tree[i])) {
                Map.Entry<Integer, Integer> tmp = null;
                for (Map.Entry<Integer, Integer> entry : fruitNow.entrySet()) {
                    if (tmp == null || tmp.getValue() > entry.getValue())
                        tmp = entry;
                }
                fruitNow.remove(tmp.getKey());
                leftPos = tmp.getValue() + 1;
            } else {
                fruitNow.put(tree[i], i);
            }
            rightPos++;
            currRes = rightPos - leftPos;
            res = Math.max(res, currRes);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] test = {0,1,1,4,3};
        System.out.println(totalFruit(test));
    }
}
