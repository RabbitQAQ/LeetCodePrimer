package com.rabbit.solution.easy;

import com.rabbit.solution.utils.Interval;

import java.util.Arrays;
import java.util.Comparator;

public class Solution252 {
    public static boolean canAttendMeetings(Interval[] intervals) {
        if (intervals.length == 1) {
            return true;
        }
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start == o2.start) return 0;
                return o1.start < o2.start ? -1 : 1;
            }
        });

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start < intervals[i - 1].end)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Interval test1 = new Interval();
        test1.start = 7;
        test1.end = 10;
        Interval test2 = new Interval();
        test2.start = 2;
        test2.end = 4;
        Interval[] testcase = {test1, test2};
        canAttendMeetings(testcase);
    }
}
