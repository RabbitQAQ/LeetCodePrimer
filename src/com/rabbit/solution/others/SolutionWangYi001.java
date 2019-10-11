package com.rabbit.solution.others;

import java.util.*;
public class SolutionWangYi001 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] in1 = scan.nextLine().split(" ");
        int n = Integer.valueOf(in1[0]);
        int m = Integer.valueOf(in1[1]);
        String[] containsString = scan.nextLine().split(" ");
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> currMap = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            map.put(i, Integer.valueOf(containsString[i]));
            currMap.put(i, Integer.valueOf(containsString[i]));
        }
        for (int i = 0; i < m; i++) {
            String[] input = scan.nextLine().split(" ");
            if (input.length == 2) {
                int level = Integer.valueOf(input[1]);
                System.out.println(map.get(level) - currMap.get(level));
            } else if (input.length == 3) {
                int level = Integer.valueOf(input[1]);
                int totalV = Integer.valueOf(input[2]);
                while (level <= n && totalV > 0) {
                    if (currMap.get(level) >= totalV) {
                        currMap.put(level, currMap.get(level) - totalV);
                        totalV = 0;
                    } else {
                        totalV -= currMap.get(level);
                        currMap.put(level, 0);
                        level++;
                    }
                }
            }
        }
    }
}