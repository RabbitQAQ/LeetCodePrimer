package com.rabbit.solution.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1192 {
    // 真题可能遇到的一些问题
    /*
    输出要排序，即使是[3,1]也要保存成[1,3]。理论上真题会给一个PairInt的数据结构来代替这里res里的List<Integer>
    整个数组最好也排一下序（存疑，testcase不过的时候可以试一下）
    真题应该是从1开始，这里是从0开始。应该只需要把数组扩大一格，循环从1开始即可。
    可参考的材料：
    https://leetcode.com/playground/vRuSiQi6
    https://www.1point3acres.com/bbs/thread-555222-1-1.html
    https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=556134&extra=page%3D6%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3089%5D%5Bvalue%5D%5B5%5D%3D5%26searchoption%5B3089%5D%5Btype%5D%3Dcheckbox%26searchoption%5B3046%5D%5Bvalue%5D%3D5%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311%26orderby%3Ddateline
    https://docs.google.com/document/d/1X40qSIwT5c6G_Myc8IW1snPunTi5DJjWZe5Zhu-GHL0/edit#
     */
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
