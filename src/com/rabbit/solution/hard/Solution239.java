package com.rabbit.solution.hard;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Solution239 {
    public int[] maxSlidingWindow2(int[] nums, int k) {
        if (k == 0) {
            return new int[0];
        }
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        int resIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            if (i >= k - 1) {
                res[resIndex++] = nums[deque.peekFirst()];
            }
        }

        return res;
    }

    class Pair {
        int val;
        int index;
        public Pair(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 0) {
            return new int[0];
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> (b.val - a.val));
        int[] res = new int[nums.length - k + 1];
        int resIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!pq.isEmpty() && pq.peek().index <= i - k) {
                pq.poll();
            }
            pq.offer(new Pair(nums[i], i));
            if (i >= k - 1) {
                res[resIndex++] = pq.peek().val;
            }
        }

        return res;
    }
}
