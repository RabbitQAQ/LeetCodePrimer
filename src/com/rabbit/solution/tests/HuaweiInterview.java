package com.rabbit.solution.tests;

import java.util.Comparator;
import java.util.PriorityQueue;

public class HuaweiInterview {

    static class Paper {
        int time;
        int value;
        double weight;
        public Paper(int t, int v) {
            time = t;
            value = v;
            weight = (double) value / time;
        }
    }

    public static double getMaxValue(int nPapers, int nRemain, int[][] paper) {
        // init pq, order by Paper.weight desc
        PriorityQueue<Paper> pq = new PriorityQueue<>(new Comparator<Paper>() {
            @Override
            public int compare(Paper o1, Paper o2) {
                if (o1.weight > o2.weight) {
                    return -1;
                } else if (o1.weight == o2.weight) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });

        for (int i = 0; i < nPapers; i++) {
            pq.offer(new Paper(paper[i][0], paper[i][1]));
        }

        // do the most valuable paper first
        double maxValue = 0;
        while (!pq.isEmpty() && nRemain > 0) {
            Paper curr = pq.poll();
            if (curr.time > nRemain) {
                maxValue += nRemain * curr.weight;
                break;
            } else {
                maxValue += curr.value;
                nRemain -= curr.time;
            }
        }

        return maxValue;
    }

    public static void main(String[] args) {
        int[][] testcase = {
                {2,3},
                {1,2},
                {2,5}
        };
        System.out.println(getMaxValue(3, 4, testcase));
    }
}
