package com.rabbit.solution.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0, right = 0;
        List<Integer> res = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] >= x && i == 0) || (arr[i] <= x && i == arr.length - 1) || (arr[i] <= x && arr[i + 1] > x)) {
                left = i;
                right = i + 1;
                while ((left >= 0 || right <= arr.length - 1) && count < k) {
                    count++;
                    Integer leftCurr = left >= 0 ? arr[left] : null;
                    Integer rightCurr = right <= arr.length - 1 ? arr[right] : null;
                    if (leftCurr != null && rightCurr != null) {
                        if (Math.abs(leftCurr - x) == Math.abs(rightCurr - x)) {
                            res.add(leftCurr);
                            left--;
                            continue;
                        }
                        boolean temp = Math.abs(leftCurr - x) > Math.abs(rightCurr - x);
                        res.add(temp ? rightCurr : leftCurr);
                        if (temp)
                            right++;
                        else
                            left--;
                    } else {
                        res.add(leftCurr == null ? rightCurr : leftCurr);
                        if (leftCurr == null)
                            right++;
                        else
                            left--;
                    }
                }
            }
        }
        Collections.sort(res);
        return res;
    }
}
