package com.rabbit.solution.others;

import java.util.*;

public class SolutionYouZan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while (sc.hasNext()) {
            list.add(sc.nextInt());
        }
        System.out.println(lack(list));
    }

    private static Integer lack(List<Integer> source) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < source.size(); i++) {
            set.add(source.get(i));
        }
        int res = 0;
        while (true) {
            if (!set.contains(res)) {
                return res;
            }
            res++;
        }
    }
}