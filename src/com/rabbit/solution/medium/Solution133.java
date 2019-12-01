package com.rabbit.solution.medium;

import java.util.*;

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val, List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};

public class Solution133 {

    /*
    通过queue遍历所有node，通过map的key来保证不重复访问
    对于每个node，除了初始化其对应的new node以外，也可以直接初始化其所有neighbor
    对于后续遍历到的node，它们实际上都已经被new过但未赋值，所以直接从map中取即可
     */

    public Node cloneGraph3(Node node) {
        Queue<Node> queue = new LinkedList<>();
        Map<Node, Node> map = new HashMap<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            Node currNode = queue.poll();
            map.putIfAbsent(currNode, new Node(currNode.val, new ArrayList<>()));
            Node newNode = map.get(currNode);
            for (Node neighbor : currNode.neighbors) {
                if (!map.containsKey(neighbor)) {
                    queue.offer(neighbor);
                }
                map.putIfAbsent(neighbor, new Node(neighbor.val, new ArrayList<>()));
                newNode.neighbors.add(map.get(neighbor));
            }
        }

        return map.get(node);
    }

    public Node cloneGraph2(Node node) {
        Map<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        // first time bfs
        queue.offer(node);
        visited.add(node);
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            Node newNode = new Node(curr.val, new ArrayList<>());
            map.put(curr, newNode);

            for (Node n : curr.neighbors) {
                if (!visited.contains(n)) {
                    queue.offer(n);
                    visited.add(n);
                }
            }
        }
        // second time bfs
        visited.clear();
        queue.offer(node);
        visited.add(node);
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            Node newNode = map.get(curr);
            visited.add(curr);
            for (Node n : curr.neighbors) {
                newNode.neighbors.add(map.get(n));
                if (!visited.contains(n)) {
                    queue.offer(n);
                    visited.add(n);
                }
            }
        }

        return map.get(node);
    }

    public Node cloneGraph(Node node) {
        Map<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        map.put(node, new Node(node.val, new ArrayList<>()));
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            Node newCurr = map.get(curr);
            for (int i = 0; i < curr.neighbors.size(); i++) {
                Node n = curr.neighbors.get(i);
                if (!map.containsKey(n)) {
                    Node newN = new Node(n.val, new ArrayList<>());
                    newCurr.neighbors.add(newN);
                    queue.offer(n);
                    map.put(n, newN);
                } else {
                    newCurr.neighbors.add(map.get(n));
                }
            }
            map.put(curr, newCurr);
        }

        return map.get(node);
    }

    public static void main(String[] args) {
//        Node n1 = new Node(1, new ArrayList<>());
//        Node n2 = new Node(2, new ArrayList<>());
//        Node n3 = new Node(3, new ArrayList<>());
//        Node n4 = new Node(4, new ArrayList<>());
//        n1.neighbors.add(n2);
//        n1.neighbors.add(n4);
//        n2.neighbors.add(n1);
//        n2.neighbors.add(n3);
//        n3.neighbors.add(n2);
//        n3.neighbors.add(n4);
//        n4.neighbors.add(n1);
//        n4.neighbors.add(n3);
//        Node res = cloneGraph2(n1);
    }
}
