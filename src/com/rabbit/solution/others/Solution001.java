package com.rabbit.solution.others;

public class Solution001 {
    public static int[][] solution(int n) {
        int[][] result = new int[n][n];
        int count = 1;
        // 上半部分
        for (int i = 1; i < n + 1; i++) {
            if (i % 2 == 0) {
                int j = i - 1, k = 0;
                while (j >= 0) {
                    result[j][k] = count;
                    j--;
                    k++;
                    count++;
                }
            } else {
                int j = 0, k = i - 1;
                while(k >= 0) {
                    result[j][k] = count;
                    k--;
                    j++;
                    count++;
                }
            }
        }

        // 下半部分
        for (int i = n + 1; i < 2 * n; i++) {
            int temp = i - n;
            if (n % 2 == 0 ? temp % 2 == 1 : temp % 2 != 1) {
                int j = temp, k = n - 1;
                while (k >= temp) {
                    result[j][k] = count;
                    count++;
                    k--;
                    j++;
                }
            } else {
                int j = n - 1, k = temp;
                while (j >= temp) {
                    result[j][k] = count;
                    count++;
                    j--;
                    k++;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] result = solution(10);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + "\t");
            }
            System.out.println("");
        }
    }
}
