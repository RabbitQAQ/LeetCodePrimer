package com.rabbit.solution.medium;

public class Solution289 {
    public void gameOfLife(int[][] board) {
        // 0 - 死变死
        // 1 - 活变活
        // 2 - 活变死
        // 3 - 死变活
        int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
        int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int cnt = 0;
                for (int k = 0; k < 8; k++) {
                    if (i + dx[k] >= 0 && j + dy[k] >= 0 && i + dx[k] < board.length && j + dy[k] < board[0].length) {
                        if (board[i + dx[k]][j + dy[k]] == 1 || board[i + dx[k]][j + dy[k]] == 2)
                            cnt++;
                    }
                }

                if (cnt < 2 || cnt > 3)
                    board[i][j] = board[i][j] == 0 ? 0 : 2;
                else if (cnt == 3)
                    board[i][j] = board[i][j] == 0 ? 3 : 1;

            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = board[i][j] % 2;
            }
        }
    }
}
