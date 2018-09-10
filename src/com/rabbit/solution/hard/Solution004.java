package com.rabbit.solution.hard;

import java.util.Arrays;

public class Solution004 {
    // 第一次遇到hard难度的题。。真不愧是hard难度。。。
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int left = (m + n + 1) / 2, right = (m + n + 2) / 2;
        return (findKth(nums1, nums2, left) + findKth(nums1, nums2, right)) / 2.0;
    }

    public static int findKth(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) {
            return findKth(nums2, nums1, k);
        }
        if (m == 0) {
            return nums2[k - 1];
        }
        if (k == 1) {
            return nums1[0] > nums2[0] ? nums2[0] : nums1[0];
        }
        int i = Math.min(m, k / 2), j = Math.min(n, k / 2);
        if (nums1[i - 1] > nums2[j - 1]) {
            return findKth(nums1, Arrays.copyOfRange(nums2, j, n), k - j);
        } else {
            return findKth(nums2, Arrays.copyOfRange(nums1, i, m), k - i);
        }
    }

    public static void main(String[] args) {
        int[] test1 = {1};
        int[] test2 = {3,4};
        System.out.println(findMedianSortedArrays(test1, test2));
    }
}