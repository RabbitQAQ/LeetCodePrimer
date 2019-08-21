package com.rabbit.solution.others;

import java.util.Scanner;

public class SolutionTouTiao002 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        String s = sc.next();

        int[] dp = new int[n];
        dp[0] = s.charAt(0) - '0';
        StringBuilder res = new StringBuilder();
        res.append(String.valueOf(dp[0]));
        for (int i = 1; i < k; i++) {
            int currS = s.charAt(i) - '0';
            if (dp[i - 1] == currS) {
                res.append('0');
                dp[i] = 1;
            } else {
                res.append('1');
                dp[i] = 0;
            }
        }

        for (int i = k, j = 0; i < n; i++, j++) {
            int startS = res.charAt(j) - '0';
            int currS = s.charAt(i) - '0';
            int currXor = startS == dp[i - 1] ? 0 : 1;
            if (currXor == currS) {
                res.append('0');
                dp[i] = currS;
            } else {
                res.append('1');
                dp[i] = currS;
            }
        }

        System.out.println(res.toString());
    }
}
