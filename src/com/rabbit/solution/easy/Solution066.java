package com.rabbit.solution.easy;

import java.util.ArrayList;
import java.util.Collections;

public class Solution066 {
    public static int[] plusOne(int[] digits) {
        if (digits.length == 0) {
            return null;
        }
        ArrayList<Integer> result = new ArrayList<>();
        int flag = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (i == digits.length - 1) {
                digits[i] = digits[i] + 1 + flag;
            } else {
                digits[i] = digits[i] + flag;
            }

            if (digits[i] >= 10) {
                digits[i] = 0;
                flag = 1;
            } else {
                flag = 0;
            }

            result.add(digits[i]);
        }

        if (flag != 0) {
            result.add(flag);
        }

        Collections.reverse(result);

        int[] intResult = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            intResult[i] = result.get(i);
        }

        return intResult;
    }

    public static void main(String[] args) {
        int[] nums = {9, 9, 9};
        int[] result = plusOne(nums);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
