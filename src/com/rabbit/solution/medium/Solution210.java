package com.rabbit.solution.medium;

import java.util.*;

public class Solution210 {
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> preMap = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            preMap.add(new ArrayList<>());
        }
        int[] numMap = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            int pre = prerequisites[i][1];
            int course = prerequisites[i][0];
            preMap.get(pre).add(course);
            numMap[course]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numMap.length; i++) {
            if (numMap[i] == 0)
                queue.offer(i);
        }
        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            int currCourse = queue.poll();
            res.add(currCourse);
            List<Integer> nextSteps = preMap.get(currCourse);
            for (Integer i: nextSteps) {
                numMap[i]--;
                if (numMap[i] == 0)
                    queue.offer(i);
            }
        }

        if (res.size() != numCourses)
            return new int[0];
        int[] trueRes = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            trueRes[i] = res.get(i);
        }

        return trueRes;
    }

    public static void main(String[] args) {
        int[][] testcase = {{1,0}};
        findOrder(2, testcase);
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        pq.poll();
    }
}
