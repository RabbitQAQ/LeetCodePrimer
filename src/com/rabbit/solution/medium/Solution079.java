package com.rabbit.solution.medium;

import java.util.List;

public class Solution079 {
    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || board[0].length == 0) {
            return false;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean[][] visited = new boolean[board.length][board[0].length];
                if (helper(board, word, 0, i, j, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean helper(char[][] board, String word, int index, int i, int j, boolean[][] visited) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || board[i][j] != word.charAt(index)) {
            return false;
        } else if (index == word.length() - 1) {
            return true;
        }
        visited[i][j] = true;
        boolean res = helper(board, word, index + 1, i + 1, j, visited) ||
                helper(board, word, index + 1, i - 1, j, visited) ||
                helper(board, word, index + 1, i, j + 1, visited) ||
                helper(board, word, index + 1, i, j - 1, visited);
        visited[i][j] = false;
        return res;
    }
}
