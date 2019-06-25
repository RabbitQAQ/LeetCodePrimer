package com.rabbit.solution.medium;

public class Solution200 {
    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int res = 0;
        int[][] record = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && record[i][j] != 1) {
                    dfs(grid, record, i, j);
                    res++;
                }
            }
        }

        return res;
    }
    public void dfs(char[][] grid, int[][] record, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return;
        }
        if (grid[i][j] == '1' && record[i][j] != 1) {
            record[i][j] = 1;
            dfs(grid, record, i + 1, j);
            dfs(grid, record, i - 1, j);
            dfs(grid, record, i, j + 1);
            dfs(grid, record, i, j - 1);
        }
    }
}
