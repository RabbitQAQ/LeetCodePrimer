package com.rabbit.solution.medium;

public class Solution062 {
    // 机器人一共走了m+n-2步，其中向下（向右）走的步数是n - 1 > m - 1 ? m - 1 : n - 1步，则按组合数就是C(m+n-2)^(x-1)
    public static int uniquePaths(int m, int n) {
        int totalSteps = m + n - 2;
        int fewerSteps = m - 1 > n - 1 ? n - 1 : m - 1;
        if (fewerSteps == 0) {
            return 1;
        }
        double diviend = totalSteps;
        double divisor = fewerSteps;
        for (double i = 1; i < fewerSteps; i++)
            diviend *= (totalSteps - i);
        for (double i = divisor - 1; i > 0; i--)
            divisor *= i;

        return (int) (diviend / divisor);
    }

    // 下面这个方法已超时
    public static int uniquePaths1(int m, int n) {
        int res = uniquePathsMinusOne1(m - 1, n - 1);
        return res;
    }

    public static int uniquePathsMinusOne1(int m, int n) {
        if (m == 0 || n == 0) {
            return 1;
        }
        return uniquePathsMinusOne1(m - 1, n) + uniquePathsMinusOne1(m, n - 1);
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(10,10));
    }
}
