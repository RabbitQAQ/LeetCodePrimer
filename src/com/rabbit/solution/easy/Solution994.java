package com.rabbit.solution.easy;

import java.util.LinkedList;
import java.util.Queue;

// 标准化的dfs题，复制粘贴的时候注意要改的地方是不是都改了
public class Solution994 {

    class Pos {
        int x;
        int y;
        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int orangesRotting(int[][] grid) {
        Queue<Pos> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new Pos(i, j));
                }
            }
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int n = queue.size();
            boolean isRotten = false;
            for (int i = 0; i < n; i++) {
                Pos currPos = queue.poll();
                if (tryRotten(grid, currPos.x - 1, currPos.y)) {
                    queue.offer(new Pos(currPos.x - 1, currPos.y));
                    isRotten = true;
                }
                if (tryRotten(grid, currPos.x + 1, currPos.y)) {
                    queue.offer(new Pos(currPos.x + 1, currPos.y));
                    isRotten = true;
                }
                if (tryRotten(grid, currPos.x, currPos.y - 1)) {
                    queue.offer(new Pos(currPos.x, currPos.y - 1));
                    isRotten = true;
                }
                if (tryRotten(grid, currPos.x, currPos.y + 1)) {
                    queue.offer(new Pos(currPos.x, currPos.y + 1));
                    isRotten = true;
                }
            }
            if (isRotten) {
                count++;
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return count;
    }

    public boolean tryRotten(int[][] grid, int x, int y) {
        if (x >= grid.length || x < 0 || y >= grid[0].length || y < 0 || grid[x][y] == 2 || grid[x][y] == 0) {
            return false;
        }
        grid[x][y] = 2;
        return true;
    }
}
