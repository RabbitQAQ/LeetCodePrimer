package com.rabbit.solution.hard;

import com.rabbit.solution.utils.ListNode;
import javafx.util.Pair;

import java.util.*;
class LRUNode {
    int key;
    int val;
    LRUNode prev;
    LRUNode next;

    public LRUNode(int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

class LRUCache {

    Map<Integer, LRUNode> quickMap;
    LRUNode head;
    LRUNode tail;
    int capacity;
    int count;

    public LRUCache(int capacity) {
        // init
        this.capacity = capacity;
        count = 0;
        quickMap = new HashMap<>();
        head = new LRUNode(-1, -1);
        tail = new LRUNode(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (quickMap.containsKey(key)) {
            LRUNode tmpNode = quickMap.get(key);
            deleteNode(tmpNode);
            moveNodeToHead(tmpNode);
            return tmpNode.val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (quickMap.containsKey(key)) {
            LRUNode tmpNode = quickMap.get(key);
            tmpNode.val = value;
            deleteNode(tmpNode);
            moveNodeToHead(tmpNode);
        } else {
            LRUNode newNode = new LRUNode(key, value);
            quickMap.put(key, newNode);
            moveNodeToHead(newNode);
            if (++count > capacity) {
                quickMap.remove(tail.prev.key);
                deleteNode(tail.prev);
            }
        }
    }

    private void deleteNode(LRUNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveNodeToHead(LRUNode node) {
        head.next.prev = node;
        node.next = head.next;
        head.next = node;
        node.prev = head;
    }
}
public class Solution146 {

    public static void main(String[] args) {
        LRUCache c = new LRUCache(2);
        c.put(1,1);
        c.put(2,2);
        c.get(1);
        c.put(3,3);
    }
}

