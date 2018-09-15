package com.rabbit.solution.others;

public class Solution002 {
    // 快速排序
    public static void quickSort(int[] input, int start, int end) {
        int l = start, r = end;
        int key = input[l];
        while (l < r) {
            while (r > l) {
                if (input[r] < key) {
                    int temp = input[r];
                    input[r] = input[l];
                    input[l] = temp;
                    break;
                }
                r--;
            }
            while (l < r) {
                if (input[l] > key) {
                    int temp = input[r];
                    input[r] = input[l];
                    input[l] = temp;
                    break;
                }
                l++;
            }
        }
        if (r < end) quickSort(input, r + 1, end);
        if (l > start) quickSort(input, start, l - 1);
    }

    public static void main(String[] args) {
        int[] testcase = {9,8,7,6,5,4,3,2,1,2,3,4,1,5,6,7,1,7,3,2};
        quickSort(testcase, 0, testcase.length - 1);
        for (int i = 0; i < testcase.length; i++) {
            System.out.println(testcase[i]);
        }
    }
}
