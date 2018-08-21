package com.rabbit.solution.easy;

public class Solution088 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            for (int j = 0; j < nums2.length; j++) {
                nums1[j] = nums2[j];
            }
            return;
        }
        if (n == 0) {
            return;
        }
        int[] result = new int[m + n];
        int i = 0;
        int mi = 0;
        int ni = 0;
        while (mi < m || ni < n) {
            if (mi >= m) {
                result[i] = nums2[ni];
                ni++;
                i++;
                continue;
            }
            if (ni >= n) {
                result[i] = nums1[mi];
                mi++;
                i++;
                continue;
            }
            if (nums1[mi] > nums2[ni]) {
                result[i] = nums2[ni];
                ni++;
                i++;
                continue;
            } else {
                result[i] = nums1[mi];
                mi++;
                i++;
                continue;
            }
        }

        for (int j = 0; j < result.length; j++) {
            nums1[j] = result[j];
        }

    }

    public static void main(String[] args) {
        int[] num1 = {1,2,3,0,0,0};
        int[] num2 = {2,5,6};

        merge(num1,3, num2, 3);
    }
}
