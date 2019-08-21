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
}
