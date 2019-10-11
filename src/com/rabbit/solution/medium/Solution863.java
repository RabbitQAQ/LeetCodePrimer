package com.rabbit.solution.medium;

import com.rabbit.solution.utils.TreeNode;

import java.util.*;

public class Solution863 {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        Map<TreeNode, TreeNode> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        findParent(root, map);
        dfs(target, K, res, map, new HashSet<>());
        return res;
    }

    public void findParent(TreeNode root, Map<TreeNode, TreeNode> map) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            map.put(root.left, root);
        }
        if (root.right != null) {
            map.put(root.right, root);
        }
        findParent(root.left, map);
        findParent(root.right, map);
    }

    public void dfs(TreeNode root, int K, List<Integer> res, Map<TreeNode, TreeNode> map, Set<TreeNode> visited) {
        if (root == null || visited.contains(root)) {
            return;
        }
        visited.add(root);
        if (K == 0) {
            res.add(root.val);
            return;
        }
        dfs(root.left, K - 1, res, map, visited);
        dfs(root.right, K - 1, res, map, visited);
        dfs(map.get(root), K - 1, res, map, visited);
    }
}
