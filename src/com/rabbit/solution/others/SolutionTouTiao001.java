package com.rabbit.solution.others;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SolutionTouTiao001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<int[]> alarms = new ArrayList<>();
        for(int i = 0; i < n; i++){
            alarms.add(new int[] {sc.nextInt(), sc.nextInt()});
        }
        int cost = sc.nextInt();
        int classHour = sc.nextInt();
        int classMin = sc.nextInt();

        int scheduledTime = classHour * 60 + classMin - cost;
        if (scheduledTime < 0) {
            scheduledTime = 1440 - scheduledTime;
        }
//        int scheduledHour = scheduledTime / 60;
//        int scheduledMin = scheduledTime % 60;
        int maxTime = Integer.MIN_VALUE;
//        int maxHour = Integer.MIN_VALUE;
//        int maxMin = Integer.MIN_VALUE;
        for (int i = 0; i < alarms.size(); i++) {
            int[] curr = alarms.get(i);
            int totalTimeCurr = curr[0] * 60 + curr[1];
            if (totalTimeCurr <= scheduledTime) {
                if (maxTime < totalTimeCurr) {
                    maxTime = totalTimeCurr;
                }
            }
        }

        System.out.println(maxTime / 60 + " " + maxTime % 60);
    }
}
