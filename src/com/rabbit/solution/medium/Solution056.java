package com.rabbit.solution.medium;

import com.rabbit.solution.utils.Interval;
import com.rabbit.solution.utils.ListNode;

import java.util.*;

public class Solution056 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < intervals.length; i++) {
            if (stack.isEmpty() || stack.peek()[1] < intervals[i][0]) {
                stack.push(intervals[i]);
            } else {
                stack.peek()[1] = Math.max(intervals[i][1], stack.peek()[1]);
            }
        }
        int[][] res = new int[stack.size()][2];
        for (int i = res.length - 1; i >= 0; i--) {
            int[] tmp = stack.pop();
            res[i][0] = tmp[0];
            res[i][1] = tmp[1];
        }
        return res;
    }
}
