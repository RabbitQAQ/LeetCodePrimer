package com.rabbit.solution.others;

public class SolutionBinarySearch {
    public static void main(String[] args) {
        //System.out.println(binarySearch(new int[] {1,1,1,1}, 0));
        System.out.println(binarySearch(new int[] {2, 4, 4, 6, 8, 10}, 5));
    }

    /*
    nums[mid] < target
    left 从前往后，第一个大于等于target的下标
    right 从后往前，第一个小于target的下标

    nums[mid] <= target
    left 从前往后，第一个大于target的下标
    right 从后往前，第一个小于等于target的下标
     */

    public static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return right;
    }
}
