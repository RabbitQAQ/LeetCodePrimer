package com.rabbit.solution.medium;

import com.rabbit.solution.utils.Interval;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution253 {
    public int minMeetingRooms(Interval[] intervals) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        for (int i = 0; i < intervals.length; i++) {
            if (!queue.isEmpty() && intervals[i].start >= queue.peek()) queue.poll();
            queue.offer(intervals[i].end);
        }

        return queue.size();
    }

    public static void main(String[] args) {
        Interval test1 = new Interval();
        test1.start = 2;
        test1.end = 6;
        Interval test2 = new Interval();
        test2.start = 4;
        test2.end = 7;
        PriorityQueue<Interval> queue = new PriorityQueue<>(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o2.start - o1.start;
            }
        });

        queue.offer(test2);
        queue.offer(test1);
        System.out.println(queue);
    }
}
