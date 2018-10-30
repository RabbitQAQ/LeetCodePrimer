package com.rabbit.solution.hard;

import com.rabbit.solution.utils.ListNode;
import javafx.util.Pair;

import java.util.*;

public class Solution146 {
    class ListNodeLRU {
        public int key;
        public int value;
        public ListNodeLRU prev;
        public ListNodeLRU next;

        ListNodeLRU(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    class LRUCache {
        Map<Integer, ListNodeLRU> quickMap;
        int capacity;
        int count;
        ListNodeLRU head;
        ListNodeLRU tail;

        public LRUCache(int capacity) {
            quickMap = new HashMap<>();
            this.capacity = capacity;
            count = 0;
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            if (quickMap.containsKey(key)) {
                ListNodeLRU curr = quickMap.get(key);
                deleteNode(curr);
                moveNodeToHead(curr);
                return curr.value;
            } else {
                return -1;
            }
        }

        public void put(int key, int value) {
            if (quickMap.containsKey(key)) {
                ListNodeLRU curr = quickMap.get(key);
                curr.value = value;
                // 删除原有元素
                deleteNode(curr);
                // 添加新元素
                moveNodeToHead(curr);
            } else {
                // 添加新元素(考虑限额)
                ListNodeLRU newNode = new ListNodeLRU(key, value);
                moveNodeToHead(newNode);
                if (++count > capacity){
                    quickMap.remove(tail.prev.key);
                    deleteNode(tail.prev);
                    --count;
                }
                quickMap.put(key, newNode);
            }
        }

        public void moveNodeToHead(ListNodeLRU node) {
            node.next = head.next;
            node.next.prev = node;
            head.next = node;
            node.prev = head;
        }

        public void deleteNode(ListNodeLRU node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

    public static void main(String[] args) {

    }
}

