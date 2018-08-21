package com.rabbit.solution.easy;

import java.util.ArrayList;
import java.util.List;

public class Solution119 {
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < rowIndex + 1; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    temp.add(1);
                } else {
                    temp.add(result.get(j - 1) + result.get(j));
                }
            }
            result = temp;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(getRow(3));
    }
}
