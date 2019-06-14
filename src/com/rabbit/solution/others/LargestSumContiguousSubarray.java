package com.rabbit.solution.others;

//最大区间和
public class LargestSumContiguousSubarray {
    public static int solution(int[] array) {
        if (array.length == 0)
            return 0;
        // dp[i]代表以i结尾的最大区间和
        int[] dp = new int[array.length];
        dp[0] = array[0];
        for (int i = 1; i < array.length; i++) {
            dp[i] = Math.max(0, dp[i - 1]) + array[i];
        }
        int max = 0;
        int start = 0;
        int end = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > max) {
                end = i;
                max = dp[i];
            }
        }
        for (int i = end; i >= 0; i--) {
            if (dp[i] == array[i]) {
                start = i;
                break;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] testcase = {0,1,-1,2,3,4,-10,5,7,8};
        System.out.println(solution(testcase));
    }
}
