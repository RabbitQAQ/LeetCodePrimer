package com.rabbit.solution.medium;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution694 {
    public int numDistinctIslands(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Set<List<Pair<Integer, Integer>>> resSet = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    List<Pair<Integer, Integer>> tmp = new ArrayList<>();
                    goDFS(grid, visited, i, j, 0, 0, tmp);
                    resSet.add(tmp);
                }
            }
        }

        return resSet.size();
    }

    public void goDFS(int[][] grid, boolean[][] visited, int x, int y, int tx, int ty, List<Pair<Integer, Integer>> tmp) {
        if (!visited[x][y]) {
            visited[x][y] = true;
            tmp.add(new Pair<Integer, Integer>(tx, ty));
        } else
            return;
        if (checkBoard(grid, x - 1, y))
            goDFS(grid, visited, x - 1, y, tx - 1, ty, tmp);
        if (checkBoard(grid, x + 1, y))
            goDFS(grid, visited, x + 1, y, tx + 1, ty, tmp);
        if (checkBoard(grid, x, y - 1))
            goDFS(grid, visited, x, y - 1, tx, ty - 1, tmp);
        if (checkBoard(grid, x, y + 1))
            goDFS(grid, visited, x, y + 1, tx, ty + 1, tmp);

    }

    public boolean checkBoard(int[][] grid, int x, int y) {
        if (x >= grid.length || x < 0 || y >= grid[0].length || y < 0) {
            return false;
        }
        return grid[x][y] == 1;
    }

}
