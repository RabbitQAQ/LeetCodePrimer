package com.rabbit.solution.utils;

import javafx.util.Pair;

import java.util.*;

public class Test {

    public void print(int n) {
        int[][] tarray = new int[n][];
        for (int i = 0; i < n; i++) {
            StringBuilder spaces = new StringBuilder();
            for (int j = 0; j < n - i; j++) {
                spaces.append(" ");
            }
            tarray[i] = new int[i + 1];
            System.out.print(spaces.toString());
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    tarray[i][j] = 1;
                } else {
                    tarray[i][j] = tarray[i - 1][j] + tarray[i - 1][j - 1];
                }
                System.out.print(tarray[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void printSixLines() {
        print(6);
    }

    public static void main(String[] args) {

//        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1 - o2;
//            }
//        });
//
//        PriorityQueue<Tmp> queue = new PriorityQueue<>((x, y) -> (x.val - y.val));
//        queue.offer(new Tmp(1));
//        queue.offer(new Tmp(2));
//        queue.offer(new Tmp(3));
//        queue.offer(new Tmp(4));
//
//        while (!queue.isEmpty())
//            System.out.println(queue.poll());

//        List<Integer> list = new ArrayList<>();
//        Map<Integer, Integer> map = new HashMap<>();
//        list.add(1);
//        Queue<Integer> queue = new LinkedList<>();

//        List<Pair<Integer, Integer>> fuck = new ArrayList<>();
//        Pair<Integer, Integer> tmp = new Pair<>(0,0);
//        Set<Integer> set = new HashSet<>();
        
    }
}
