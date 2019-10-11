package com.rabbit.solution.medium;

import java.util.*;

public class Solution207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int[] in = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            map.putIfAbsent(prerequisites[i][1], new HashSet<>());
            map.get(prerequisites[i][1]).add(prerequisites[i][0]);
            in[prerequisites[i][0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (in[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int course = queue.poll();
            if (map.containsKey(course)) {
                for (Integer num : map.get(course)) {
                    in[num]--;
                    if (in[num] == 0) {
                        queue.offer(num);
                    }
                }
            }

        }

        for (int i = 0; i < numCourses; i++) {
            if (in[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
