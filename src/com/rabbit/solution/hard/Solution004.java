package com.rabbit.solution.hard;

import java.util.Arrays;

public class Solution004 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int mid1 = (nums1.length + nums2.length + 1) / 2;
        int mid2 = (nums1.length + nums2.length + 2) / 2;
        return (findKthNumber(nums1, 0, nums2, 0, mid1) + findKthNumber(nums1, 0, nums2, 0, mid2)) / 2.0;
    }

    public double findKthNumber(int[] nums1, int i, int[] nums2, int j, int K) {
        if (i >= nums1.length) {
            return nums2[j + K - 1];
        } else if (j >= nums2.length) {
            return nums1[i + K - 1];
        } else if (K == 1) {
            return Math.min(nums1[i], nums2[j]);
        } else {
            int mid1 = (i + (K / 2) - 1 < nums1.length ? nums1[i + (K / 2) - 1] : Integer.MAX_VALUE);
            int mid2 = (j + (K / 2) - 1 < nums2.length ? nums2[j + (K / 2) - 1] : Integer.MAX_VALUE);
            if (mid1 < mid2) {
                return findKthNumber(nums1, i + K / 2, nums2, j, K - K / 2);
            } else {
                return findKthNumber(nums1, i, nums2, j + K / 2, K - K / 2);
            }
        }
    }
}