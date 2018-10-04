package com.rabbit.solution.medium;

import com.rabbit.solution.utils.Interval;
import com.rabbit.solution.utils.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution056 {
    public static List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() == 0) {
            return new ArrayList<>();
        }
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        List<Interval> res = new ArrayList<>();
        res.add(intervals.get(0));
        for (int i = 1; i < intervals.size(); i++) {
            Interval prev = res.get(res.size() - 1);
            Interval temp = intervals.get(i);
            if (prev.end >= temp.start) {
                res.remove(prev);
                res.add(new Interval(prev.start, temp.end > prev.end ? temp.end : prev.end));
            } else {
                res.add(temp);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Interval t1 = new Interval(1,3);
        Interval t2 = new Interval(2,6);
        Interval t3 = new Interval(8,10);
        Interval t4 = new Interval(15,18);
        List<Interval> testcase = new ArrayList<>();
        testcase.add(t1);
        testcase.add(t2);
        testcase.add(t3);
        testcase.add(t4);
        List<Interval> res = merge(testcase);
        System.out.println(res);
    }
}
