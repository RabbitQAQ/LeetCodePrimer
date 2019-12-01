package com.rabbit.solution.hard;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class Solution460 {
    static class LFUCache {

        Map<Integer, Integer> key2val;
        Map<Integer, Integer> key2count;
        Map<Integer, LinkedHashSet<Integer>> count2key;
        Integer min;
        Integer capacity;

        public LFUCache(int capacity) {
            this.min = -1;
            this.capacity = capacity;
            key2val = new HashMap<>();
            key2count = new HashMap<>();
            count2key = new HashMap<>();
            count2key.put(1, new LinkedHashSet<>());
        }

        public int get(int key) {
            if (!key2val.containsKey(key)) {
                return -1;
            }
            int countBefore = key2count.get(key);
            // update key2count
            key2count.put(key, countBefore + 1);
            // update count2key
            count2key.get(countBefore).remove(key);
            count2key.putIfAbsent(countBefore + 1, new LinkedHashSet<>());
            count2key.get(countBefore + 1).add(key);
            // check min update
            if (countBefore == min && count2key.get(countBefore).size() == 0) {
                min++;
            }

            return key2val.get(key);
        }

        public void put(int key, int value) {
            if (capacity <= 0) {
                return;
            }
            // update key2val
            if (key2val.containsKey(key)) {
                key2val.put(key, value);
                get(key);
                return;
            }

            // if capacity exceeded
            if (key2val.size() >= capacity) {
                int removeKey = count2key.get(min).iterator().next();
                count2key.get(min).remove(removeKey);
                key2count.remove(removeKey);
                key2val.remove(removeKey);
            }

            // reset min
            min = 1;
            // add key-value
            key2val.put(key, value);
            key2count.put(key, 1);
            count2key.get(1).add(key);
        }
    }

    public static void main(String[] args) {
        LFUCache cache = new LFUCache( 2 /* capacity */ );

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.get(3);       // returns 3.
        cache.put(4, 4);    // evicts key 1.
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4
    }
}
