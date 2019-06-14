package com.rabbit.solution.medium;

public class Solution081 {
    public static boolean search(int A[], int target) {
        int n = A.length;
        if (n == 0) return false;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (A[mid] == target) return true;
            else if (A[mid] < A[right]) {
                if (A[mid] < target && A[right] >= target) left = mid + 1;
                else right = mid - 1;
            } else if (A[mid] > A[right]){
                if (A[left] <= target && A[mid] > target) right = mid - 1;
                else left = mid + 1;
            } else --right;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] testcase = {3,1,1};
        System.out.println(search(testcase, 3));

    }
}
