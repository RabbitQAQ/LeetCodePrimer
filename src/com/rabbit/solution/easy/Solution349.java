package com.rabbit.solution.easy;

import java.util.HashSet;
import java.util.Set;

public class Solution349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> temp = new HashSet<>();
        Set<Integer> res = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            temp.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (temp.contains(nums2[i])) {
                res.add(nums2[i]);
            }
        }
        int count = 0;
        int[] trueRes = new int[res.size()];
        for (Integer integer : res) {
            trueRes[count] = integer;
            count++;
        }

        return trueRes;
    }

    public static void main(String[] args) {

    }
}
