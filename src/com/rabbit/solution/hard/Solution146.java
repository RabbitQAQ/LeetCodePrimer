package com.rabbit.solution.hard;

import com.rabbit.solution.utils.ListNode;
import javafx.util.Pair;

import java.util.*;
class LRUNode {
    int key;
    int value;
    LRUNode prev;
    LRUNode next;
    LRUNode(int k, int v, LRUNode p, LRUNode n) {
        key = k;
        value = v;
        prev = p;
        next = n;
    }
}

class LRUCache {
    Map<Integer, LRUNode> quickMap;
    int capacity;
    int count;
    LRUNode head;
    LRUNode tail;

    public LRUCache(int capacity) {
        quickMap = new HashMap<>();
        head = new LRUNode(0, 0, null, tail);
        tail = new LRUNode(0, 0, head, null);
        this.capacity = capacity;
        count = 0;
    }

    public int get(int key) {
        if (quickMap.containsKey(key)) {
            LRUNode curr = quickMap.get(key);
            deleteNode(curr);
            moveNodeToHead(curr);
            return curr.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (quickMap.containsKey(key)) {
            LRUNode curr = quickMap.get(key);
            curr.value = value;
            deleteNode(curr);
            moveNodeToHead(curr);
        } else {
            LRUNode newNode = new LRUNode(key, value, null, null);
            moveNodeToHead(newNode);
            if (++count > capacity) {
                quickMap.remove(tail.prev.key);
                deleteNode(tail.prev);
                count--;
            }
            quickMap.put(key, newNode);
        }
    }

    public void deleteNode(LRUNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void moveNodeToHead(LRUNode node) {
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }
}
public class Solution146 {

    public static void main(String[] args) {
        LRUCache c = new LRUCache(2);
        c.put(1,1);
    }
}

