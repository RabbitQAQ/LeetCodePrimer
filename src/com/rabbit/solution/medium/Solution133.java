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
