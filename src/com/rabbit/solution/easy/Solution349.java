package com.rabbit.solution.easy;

import java.util.*;

public class Solution349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> res = new HashSet<>();
        Set<Integer> tmp = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            tmp.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (tmp.contains(nums2[i])) {
                res.add(nums2[i]);
            }
        }

        int[] trueRes = new int[res.size()];
        int index = 0;
        Iterator<Integer> iter = res.iterator();
        while (iter.hasNext()) {
            trueRes[index] = iter.next();
            index++;
        }

        return trueRes;
    }

    public int[] intersection2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int p1 = 0;
        int p2 = 0;
        List<Integer> res = new ArrayList<>();
        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] == nums2[p2]) {
                res.add(nums1[p1]);
                while (p1 < nums1.length - 1 && nums1[p1] == nums1[p1 + 1]) {
                    p1++;
                }
                while (p2 < nums2.length - 1 && nums2[p2] == nums2[p2 + 1]) {
                    p2++;
                }
                p1++;
                p2++;
            } else if (nums1[p1] < nums2[p2]) {
                p1++;
            }else {
                p2++;
            }
        }

        int[] trueRes = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            trueRes[i] = res.get(i);
        }

        return trueRes;
    }
}
