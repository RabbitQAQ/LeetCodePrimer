package com.rabbit.solution.medium;

import java.util.HashMap;
import java.util.Map;

public class Solution279 {
    public int numSquares(int n) {
        while (n % 4 == 0)
            n /= 4;
        if (n % 8 == 7)
            return 4;
        for (int i = 0; i * i < n; i++) {
            int j = (int) Math.sqrt(n - i * i);
            if (j * j + i * i == n)
                return i == 0 || j == 0 ? 1 : 2;
        }

        return 3;
    }

    public static void main(String[] args) {

    }
}
