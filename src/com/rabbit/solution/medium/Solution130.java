package com.rabbit.solution.medium;

public class Solution130 {
    public void solve(char[][] board) {
        if (board.length <= 2) {
            return;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if ((i == 0 || j == 0 || i == board.length - 1 || j == board[0].length - 1) && board[i][j] == 'O') {
                    mark(board, i, j);
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void mark(char[][] board, int i, int j) {
        if ((i < 0) || (i >= board.length) || (j < 0) || (j >= board[0].length) || board[i][j] != 'O') {
            return;
        }
        board[i][j] = 'A';
        mark(board, i - 1, j);
        mark(board, i + 1, j);
        mark(board, i, j - 1);
        mark(board, i, j + 1);
    }
}
