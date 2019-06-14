package com.rabbit.solution.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution406 {
    public static int[][] reconstructQueue(int[][] people) {
        if (people.length == 0) {
            return new int[0][0];
        }
        List<List<Integer>> resort = new ArrayList<>();
        for (int i = 0; i < people.length; i++) {
            List<Integer> tmp = new ArrayList<>();
            tmp.add(people[i][0]);
            tmp.add(people[i][1]);
            resort.add(tmp);
        }
        Collections.sort(resort, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                if ((o1.get(0) > o2.get(0)) || (o1.get(0).equals(o2.get(0)) && o1.get(1) < o2.get(1))) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < resort.size(); i++) {
            res.add(resort.get(i).get(1), resort.get(i));
        }

        int[][] realres = new int[people.length][people[0].length];
        for (int i = 0; i < res.size(); i++) {
            realres[i][0] = res.get(i).get(0);
            realres[i][1] = res.get(i).get(1);
        }

        return realres;
    }

    public static void main(String[] args) {
        int[][] testcase = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        reconstructQueue(testcase);
    }
}
