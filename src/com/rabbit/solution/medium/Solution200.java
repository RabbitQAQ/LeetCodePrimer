package com.rabbit.solution.medium;

public class Solution200 {
    public static int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int count = 0;
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    goDFS(grid, visited, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    public static void goDFS(char[][] grid, boolean[][] visited, int x, int y) {
        if (!visited[x][y])
            visited[x][y] = true;
        else
            return;
        if (checkBorad(grid, x, y + 1)) {
            goDFS(grid, visited, x, y + 1);
        }
        if (checkBorad(grid, x, y - 1)) {
            goDFS(grid, visited, x, y - 1);
        }
        if (checkBorad(grid, x + 1, y)) {
            goDFS(grid, visited, x + 1, y);
        }
        if (checkBorad(grid, x - 1, y)) {
            goDFS(grid, visited, x - 1, y);
        }
        return;
    }

    public static boolean checkBorad(char[][] grid, int x, int y) {
        if (x >= grid.length || x < 0 || y >= grid[0].length || y < 0) {
            return false;
        }
        if (grid[x][y] != '1') {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] testcase = {{'1','1','1','1','0'}, {'1','1','0','1','0'}, {'1','1','0','0','0'},{'0','0','0','0','0'}};
        System.out.println(numIslands(testcase));
    }
}
