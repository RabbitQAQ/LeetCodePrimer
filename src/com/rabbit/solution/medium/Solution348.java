package com.rabbit.solution.medium;

public class Solution348 {
    class TicTacToe {

        int[] rows;
        int[] cols;
        int diag;
        int revDiag;
        int n;

        /** Initialize your data structure here. */
        public TicTacToe(int n) {
            this.rows = new int[n];
            this.cols = new int[n];
            this.diag = 0;
            this.revDiag = 0;
            this.n = n;
        }

        /** Player {player} makes a move at ({row}, {col}).
         @param row The row of the board.
         @param col The column of the board.
         @param player The player, can be either 1 or 2.
         @return The current winning condition, can be either:
         0: No one wins.
         1: Player 1 wins.
         2: Player 2 wins. */
        public int move(int row, int col, int player) {
            int plus = player == 1 ? 1 : -1;
            this.rows[row] += plus;
            this.cols[col] += plus;
            if (row == col) {
                this.diag += plus;
            }
            if (col == this.n - 1 - row) {
                this.revDiag += plus;
            }
            return (Math.abs(this.rows[row]) == n || Math.abs(this.cols[col]) == n || Math.abs(this.diag) == n || Math.abs(this.revDiag) == n) ? player : 0;
        }
    }
}
