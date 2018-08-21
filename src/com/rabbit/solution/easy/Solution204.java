package com.rabbit.solution.easy;

import java.util.ArrayList;

public class Solution204 {
    public static int countPrimes(int n) {
        if (n <= 1) {
            return 0;
        }
        boolean[] arrayList = new boolean[n];
        // 初始化List
        for (int i = 0; i < n; i++) {
            arrayList[i] = true;
        }
        arrayList[0] = false;
        arrayList[1] = false;


        // 去除非素数
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (arrayList[i] != false) {
                    for (int j = i * i; j < n; j += i) {
                        arrayList[j] = false;
                    }
            }
        }

        int count = 0;
        for (int i = 0; i < arrayList.length; i++) {
            if (arrayList[i]) {
                count++;
            }
        }

        return  count;
    }

    public static void main(String[] args) {
        System.out.println(countPrimes(3));
    }
}
