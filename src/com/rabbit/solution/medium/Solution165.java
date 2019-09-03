package com.rabbit.solution.medium;

public class Solution165 {
    public int compareVersion(String version1, String version2) {
        String[] sa1 = version1.split("\\.");
        String[] sa2 = version2.split("\\.");
        int[] nums1 = new int[sa1.length];
        int[] nums2 = new int[sa2.length];
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = Integer.valueOf(sa1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            nums2[i] = Integer.valueOf(sa2[i]);
        }
        // start
        int p1 = 0;
        int p2 = 0;
        while (p1 < nums1.length || p2 < nums2.length) {
            int curr1 = p1 >= nums1.length ? 0 : nums1[p1];
            int curr2 = p2 >= nums2.length ? 0 : nums2[p2];
            if (curr1 == curr2) {
                p1++;
                p2++;
                continue;
            } else if (curr1 > curr2) {
                return 1;
            } else if (curr1 < curr2) {
                return -1;
            }
        }

        return 0;
    }
}
