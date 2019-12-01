package com.rabbit.solution.medium;

public class Solution036 {
    public boolean isValidSudoku2(char[][] board) {
        StringBuilder res = new StringBuilder();

        boolean[][] rowflag = new boolean[9][9];
        boolean[][] colflag = new boolean[9][9];
        boolean[][] boxflag = new boolean[9][9];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                } else {
                    int num = board[i][j] - '1';
                    if (rowflag[i][num] || colflag[j][num] || boxflag[(i / 3) * 3 + j / 3][num]) {
                        return false;
                    }
                    rowflag[i][num] = true;
                    colflag[j][num] = true;
                    boxflag[(i / 3) * 3 + j / 3][num] = true;
                }
            }
        }
        return true;
    }


    public static boolean isValidSudoku(char[][] board) {
         int[][] rows = new int[9][9];
         int[][] cols = new int[9][9];
         int[][] blocks = new int[9][9];

         for (int i = 0; i < 9; i++) {
             for (int j = 0; j < 9; j++) {
                 if (board[i][j] >= '1' && board[i][j] <= '9') {
                     if (rows[i][board[i][j] - '1'] == 1) {
                         return false;
                     } else {
                         rows[i][board[i][j] - '1'] = 1;
                     }
                 }

                 if (board[j][i] >= '1' && board[j][i] <= '9') {
                     if (cols[i][board[j][i] - '1'] == 1) {
                         return false;
                     } else {
                         cols[i][board[j][i] - '1'] = 1;
                     }
                 }

                 if (board[i][j] >= '1' && board[i][j] <= '9') {
                     if (blocks[(i / 3) * 3 + j / 3][board[i][j] - '1'] == 1) {
                         return false;
                     } else {
                         blocks[(i / 3) * 3 + j / 3][board[i][j] - '1'] = 1;
                     }
                 }

             }
         }

         return true;
    }

    public static void main(String[] args) {
        String str = "[[\".\",\".\",\".\",\".\",\".\",\".\",\".\",\".\",\".\"],[\".\",\".\",\".\",\".\",\".\",\".\",\".\",\".\",\".\"],[\".\",\"9\",\".\",\".\",\".\",\".\",\".\",\".\",\"1\"],[\"8\",\".\",\".\",\".\",\".\",\".\",\".\",\".\",\".\"],[\".\",\"9\",\"9\",\"3\",\"5\",\"7\",\".\",\".\",\".\"],[\".\",\".\",\".\",\".\",\".\",\".\",\".\",\"4\",\".\"],[\".\",\".\",\".\",\"8\",\".\",\".\",\".\",\".\",\".\"],[\".\",\"1\",\".\",\".\",\".\",\".\",\"4\",\".\",\"9\"],[\".\",\".\",\".\",\"5\",\".\",\"4\",\".\",\".\",\".\"]]";
        System.out.println(str.replace("[" , "{").replace("]", "}").replace("\"", "'"));
        char[][] testcase = {{'.','.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'},{'.','9','.','.','.','.','.','.','1'},{'8','.','.','.','.','.','.','.','.'},{'.','9','9','3','5','7','.','.','.'},{'.','.','.','.','.','.','.','4','.'},{'.','.','.','8','.','.','.','.','.'},{'.','1','.','.','.','.','4','.','9'},{'.','.','.','5','.','4','.','.','.'}};
        System.out.println(isValidSudoku(testcase));
    }
}
