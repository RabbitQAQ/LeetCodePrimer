package com.rabbit.solution.others;

import java.util.Scanner;

public class SolutionTouTiao003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = sc.nextInt();
        }

        int[] dp = new int[n];
        dp[0] = 100;
        for (int i = 1; i < n - 1; i++) {
            if (p[i] > p[i - 1]) {
                dp[i] = dp[i - 1] + 100;
            } else if (p[i] == p[i - 1]) {
                dp[i] = dp[i - 1];
            } else if (p[i] < p[i - 1] && p[i] > p[i + 1]) {
                dp[i] = dp[i - 1];
                dp[i - 1] += 100;
            } else {
                dp[i] = 100;
            }
        }
        dp[n - 1] = p[n - 1] > p[n - 2] ? dp[n - 2] + 100 : 100;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += dp[i];
            System.out.println(dp[i]);
        }
        System.out.println(sum);
        String fuck = "";
    }
}
