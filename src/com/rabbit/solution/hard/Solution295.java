package com.rabbit.solution.hard;

import java.util.PriorityQueue;

public class Solution295 {
    class MedianFinder {

        // 这里的max和min代表的是出来大的还是出来小的，和最大堆最小堆的定义刚好反一反
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
