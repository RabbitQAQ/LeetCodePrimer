package com.rabbit.solution.hard;

import java.util.PriorityQueue;

public class Solution295 {
    class MedianFinder {

        PriorityQueue<Integer> maxHeap;
        PriorityQueue<Integer> minHeap;

        /** initialize your data structure here. */
        public MedianFinder() {
            this.maxHeap = new PriorityQueue<>();
            this.minHeap = new PriorityQueue<>((x, y) -> y - x);
        }

        public void addNum(int num) {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
            if (maxHeap.size() < minHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }
        }

        public double findMedian() {
            if (maxHeap.size() == minHeap.size()) {
                return (maxHeap.peek() + minHeap.peek()) / 2.0;
            } else {
                return maxHeap.peek();
            }
        }
    }
}
