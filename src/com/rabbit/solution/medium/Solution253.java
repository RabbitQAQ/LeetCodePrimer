package com.rabbit.solution.medium;

import com.rabbit.solution.utils.Interval;

import java.util.*;

public class Solution253 {
    // Tree Map
    public int minMeetingRooms(int[][] intervals) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < intervals.length; i++) {
            map.put(intervals[i][0], map.getOrDefault(intervals[i][0], 0) + 1);
            map.put(intervals[i][1], map.getOrDefault(intervals[i][1], 0) - 1);
        }
        int currSum = 0;
        int maxSum = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            currSum += entry.getValue();
            maxSum = Math.max(maxSum, currSum);
        }

        return maxSum;
    }

    // 2 array
    public int minMeetingRooms2(int[][] intervals) {
        List<Integer> startTime = new ArrayList<>();
        List<Integer> endTime = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            startTime.add(intervals[i][0]);
            endTime.add(intervals[i][1]);
        }
        Collections.sort(startTime);
        Collections.sort(endTime);
        int max = 0;
        int currSum = 0;
        int j = 0;
        for (int i = 0; i < intervals.length; ) {
            if (startTime.get(i) < endTime.get(j)) {
                currSum++;
                i++;
            } else {
                currSum--;
                j++;
            }
            max = Math.max(max, currSum);
        }

        return max;
    }

    // PQ
    public int minMeetingRooms3(int[][] intervals) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for (int i = 0; i < intervals.length; i++) {
            if (!pq.isEmpty()) {
                if (pq.peek() <= intervals[i][0]) {
                    pq.poll();
                }
                pq.offer(intervals[i][1]);
            } else {
                pq.offer(intervals[i][1]);
            }
        }
        return pq.size();
    }
}
