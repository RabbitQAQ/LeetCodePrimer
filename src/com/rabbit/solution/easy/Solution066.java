package com.rabbit.solution.easy;

import java.util.ArrayList;
import java.util.Collections;

public class Solution066 {
    public int[] plusOne(int[] digits) {
        int carry = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (carry == 0 && i != digits.length - 1) {
                return digits;
            }
            int add = (i == digits.length - 1 ? 1 : 0);
            int sum = digits[i] + add + carry;
            digits[i] = sum % 10;
            carry = sum / 10;
        }
        if (carry != 0) {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            for (int i = 1; i < res.length; i++) {
                res[i] = digits[i - 1];
            }
            return res;
        } else {
            return digits;
        }
    }
}
