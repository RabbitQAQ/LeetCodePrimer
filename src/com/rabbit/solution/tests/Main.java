package com.rabbit.solution.tests;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;
public class Main {

    static int best = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int x = scan.nextInt();
        int[] tasks = new int[n];
        for (int i = 0; i < n; i++) {
            tasks[i] = scan.nextInt();
        }
        for (int y = 1; y <= x; y++) {
            best = Integer.MAX_VALUE;
            dfs(tasks, 0, x, y, 0, 0);
            System.out.println(best);
        }
    }
    public static void dfs(int[] tasks, int index, int x, int y, int aEnd, int bEnd) {
        if (Math.min(aEnd, bEnd) >= best) {
            return;
        }
        if (index == tasks.length) {
            best = Math.min(best, Math.max(aEnd, bEnd));
            return;
        }
        dfs(tasks, index + 1, x, y, tasks[index] + x, bEnd);
        dfs(tasks, index + 1, x, y, aEnd, bEnd <= tasks[index] ? tasks[index] + y : bEnd + y);
    }

//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        String[] inputs = scan.nextLine().split(" ");
//        long k = Long.parseLong(inputs[0]);
//        long a = Long.parseLong(inputs[1]);
//        long b = Long.parseLong(inputs[2]);
//        long size1 = b - a + 1;
//        long c = Long.parseLong(inputs[3]);
//        long d = Long.parseLong(inputs[4]);
//        long size2 = d - c + 1;
//        long posMax = (long) Math.pow(2, k) - 1;
//        long negMax = (long) -Math.pow(2, k);
//        long count = 0;
//        for (long i = b; i >= a; i--) {
//            if (i + d <= posMax && i + c >= negMax) {
//                continue;
//            } else {
//                long posTarget = posMax - i;
//                if (posTarget < c) {
//                    count += size2;
//                } else if (posTarget <= d) {
//                    count += d - posTarget;
//                }
//                long negTarget = negMax - i;
//                if (negTarget < c) {
//                    count += (d - c + 1);
//                } else if (negTarget <= d) {
//                    count +=
//                }
//            }
//        }
//        BigDecimal bd = new BigDecimal(((double)count / (double)(size1 * size2))).setScale(6, RoundingMode.UP);
//        System.out.println(bd);
//    }

//    static class Interval {
//        int start;
//        int end;
//        public Interval() {
//
//        }
//        public Interval(int x, int y) {
//            this.start = x;
//            this.end = y;
//        }
//    }

//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        String[] inputs = scan.nextLine().split(" ");
//        int n = Integer.parseInt(inputs[0]);
//        int m = Integer.parseInt(inputs[1]);
//        StringBuilder bin = new StringBuilder(scan.nextLine());
//        char[] translate = new char[2];
//        translate[0] = '1';
//        translate[1] = '0';
//        Queue<Interval> queue = new LinkedList<>();
//        for (int i = 0; i < m; i++) {
//            String[] inputOps = scan.nextLine().split(" ");
//            int x = Integer.parseInt(inputOps[0]);
//            int y = Integer.parseInt(inputOps[1]);
//            if (x >= y) {
//                int tmp = x;
//                x = y;
//                y = tmp;
//            }
//            Interval tmp = new Interval(x, y);
//            int size = queue.size();
//            for (int j = 0; j < size; j++) {
//                Interval curr = queue.poll();
//                if (curr.start <= tmp.end && curr.end >= tmp.start) {
//
//                }
//            }
//        }
//        System.out.println(bin.toString());
//    }
}