package com.rabbit.solution.medium;

import java.util.List;

public class Solution079 {
    public static boolean exist(char[][] board, String word) {
        if (word.length() == 0) {
            return true;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    int[][] reached = new int[board.length][board[0].length];
                    reached[i][j] = 1;
                    if (checkAdjacent(board, reached, word, 1, i, j)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static Boolean checkAdjacent(char[][] board, int[][] reached, String word, int num, int row, int col) {
        if (num == word.length()) {
            return true;
        }
        int rowLength = board.length, colLength = board[0].length;
        char target = word.charAt(num);
        char char1 = row - 1 >= 0 && reached[row - 1][col] == 0 ? board[row - 1][col] : ' ';
        char char2 = col - 1 >= 0 && reached[row][col - 1] == 0 ? board[row][col - 1] : ' ';
        char char3 = row + 1 < rowLength && reached[row + 1][col] == 0 ? board[row + 1][col] : ' ';
        char char4 = col + 1 < colLength && reached[row][col + 1] == 0 ? board[row][col + 1] : ' ';

        if (char1 != ' ' && char1 == target) {
            reached[row - 1][col] = 1;
            if (checkAdjacent(board, reached, word, num + 1, row - 1, col)) {
                return true;
            }
            reached[row - 1][col] = 0;
        }
        if (char2 != ' ' && char2 == target) {
            reached[row][col - 1] = 1;
            if (checkAdjacent(board, reached, word, num + 1, row, col - 1)) {
                return true;
            }
            reached[row][col - 1] = 0;
        }
        if (char3 != ' ' && char3 == target) {
            reached[row + 1][col] = 1;
            if (checkAdjacent(board, reached, word, num + 1, row + 1, col)) {
                return true;
            }
            reached[row + 1][col] = 0;
        }
        if (char4 != ' ' && char4 == target) {
            reached[row][col + 1] = 1;
            if (checkAdjacent(board, reached, word, num + 1, row, col + 1)) {
                return true;
            }
            reached[row][col + 1] = 0;
        }

        return false;

    }

    public static void main(String[] args) {
        char[][] testcase = {{'A','B','C','E'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(exist(testcase, "ABCESEEEFS"));
    }
}
