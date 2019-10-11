package com.rabbit.solution.medium;

import com.rabbit.solution.utils.TreeNode;

import java.util.*;

class Pair {
    public int val;
    public int depth;
    public Pair(int v, int d) {
        val = v;
        depth = d;
    }
}

public class Solution987 {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, List<Pair>> map = new TreeMap<>();

        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> locQueue = new LinkedList<>();
        queue.offer(root);
        locQueue.offer(0);
        int currDepth = 0;
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode curr = queue.poll();
                int loc = locQueue.poll();
                if (!map.containsKey(loc)) {
                    map.put(loc, new ArrayList<>());
                }
                map.get(loc).add(new Pair(curr.val, currDepth));
                if (curr.left != null) {
                    queue.offer(curr.left);
                    locQueue.offer(loc - 1);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                    locQueue.offer(loc + 1);
                }
            }
            currDepth++;
        }


        for (List<Pair> t : map.values()) {
            Collections.sort(t, (Pair a, Pair b) -> {
                if (a.depth == b.depth) {
                    return a.val - b.val;
                }
                return 0;
            });
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < t.size(); i++) {
                tmp.add(t.get(i).val);
            }
            res.add(tmp);
        }

        return res;
    }
}
