package com.rabbit.solution.medium;

import com.rabbit.solution.utils.Utils;

import java.util.Collections;
import java.util.PriorityQueue;

public class Solution215 {
    public int findKthLargest(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = partition(nums, left, right);
            if (mid == k - 1) {
                return nums[mid];
            } else if (mid > k - 1) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

    public int partition(int[] nums, int left, int right) {
        int start = left;
        int p = nums[left++];
        while (left <= right) {
            while (left <= right && nums[left] >= p) {
                left++;
            }
            while (left <= right && nums[right] <= p) {
                right--;
            }
            if (left >= right) {
                break;
            }
            swap(nums, left, right);
        }

        swap(nums, start, right);
        return right;
    }

    public void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }


    public int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            pq.offer(nums[i]);
        }
        for (int i = 0; i < k - 1; i++) {
            pq.poll();
        }
        return pq.poll();
    }
}
