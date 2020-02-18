package com.rabbit.solution.tests;

import java.lang.reflect.Array;
import java.util.*;

public class HuaiyiTest {
    static class MedianFinder {

        PriorityQueue<Integer> minHeap;
        PriorityQueue<Integer> maxHeap;

        /** initialize your data structure here. */
        public MedianFinder() {
            minHeap = new PriorityQueue<>();
            maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        }

        public void addNum(int num) {
            maxHeap.offer(num);
            if (maxHeap.size() > minHeap.size()) {
                minHeap.offer(maxHeap.poll());
            }
        }

        public double findMedian() {
            if ((maxHeap.size() + minHeap.size()) % 2 == 0) {
                return (maxHeap.peek() + minHeap.peek()) / 2.0;
            } else {
                return maxHeap.peek();
            }
        }
    }

    public static void main(String[] args) {
        MedianFinder m = new MedianFinder();
        m.addNum(1);
        m.addNum(2);
        System.out.println(m.findMedian());
    }
}
