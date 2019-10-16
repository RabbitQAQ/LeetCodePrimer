package com.rabbit.solution.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1192 {
    int time = 0;
    int[] disc;
    int[] low;
    List<Integer>[] graph;
    List<List<Integer>> res;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        // init
        res = new ArrayList<>();
        disc = new int[n];
        low = new int[n];
        Arrays.fill(disc, -1);
        // build graph
        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (List<Integer> ls : connections) {
            graph[ls.get(0)].add(ls.get(1));
            graph[ls.get(1)].add(ls.get(0));
        }

        for (int i = 0; i < n; i++) {
            if (disc[i] == -1) {
                dfs(i, i);
            }
        }

        return res;
    }

    public void dfs(int u, int parent) {
        disc[u] = ++time;
        low[u] = disc[u];
        for (int i = 0; i < graph[u].size(); i++) {
            int v = graph[u].get(i);
            if (v == parent) {
                continue;
            } else if (disc[v] == -1) {
                dfs(v, u);
                low[u] = Math.min(low[u], low[v]);
                if (low[v] > disc[u]) {
                    res.add(Arrays.asList(u > v ? v : u, u > v ? u : v));
                }
            } else {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }
}
