package com.rabbit.solution.medium;

public class Solution547 {
    public int findCircleNum(int[][] M) {
        boolean[] visited = new boolean[M.length];
        int res = 0;
        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) {
                continue;
            }
            dfs(M, visited, i);
            res++;
        }
        return res;
    }

    public void dfs(int[][] M, boolean[] visited, int curr) {
        visited[curr] = true;
        for (int j = 0; j < M.length; j++) {
            if (M[curr][j] == 1 && !visited[j]) {
                dfs(M, visited, j);
            }
        }
    }
}
