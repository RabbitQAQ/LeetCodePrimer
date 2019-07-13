package com.rabbit.solution.easy;

public class Solution088 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int length = m + n - 1;
        int p1 = m - 1;
        int p2 = n - 1;
        while (p1 >= 0 || p2 >= 0) {
            if (p1 < 0) {
                nums1[length--] = nums2[p2--];
            } else if (p2 < 0) {
                nums1[length--] = nums1[p1--];
            } else {
                if (nums1[p1] > nums2[p2]) {
                    nums1[length--] = nums1[p1--];
                } else {
                    nums1[length--] = nums2[p2--];
                }
            }
        }
    }
}
