package com.rabbit.solution.medium;

public class Solution785 {
    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (colors[i] == 0 && !helper(graph, i, colors, 1)) {
                return false;
            }
        }
        return true;
    }

    public boolean helper(int[][] graph, int index, int[] colors, int color) {
        if (colors[index] != 0) {
            return colors[index] == color;
        }
        int[] connected = graph[index];
        colors[index] = color;
        for (int i = 0; i < connected.length; i++) {
            if (!helper(graph, connected[i], colors, -1 * color))
                return false;
        }

        return true;
    }
}
