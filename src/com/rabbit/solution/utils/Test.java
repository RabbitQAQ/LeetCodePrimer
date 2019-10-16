package com.rabbit.solution.utils;

import javafx.util.Pair;

import java.util.*;

public class Test {


    //    4 5 9 8 10 23 7 4 12 5 8 3 2 11 1 3 6 12
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        while (scan.hasNext()) {
            pq.offer(scan.nextInt());
        }
        for (int i = 0; i < m; i++) {
            int smallest = pq.poll();
            int count = 0;
            while (pq.peek() == smallest) {
                pq.poll();
                count++;
            }
            pq.offer(pq.poll() + smallest);
            for (int j = 0; j < count; j++) {
                pq.offer(smallest);
            }
        }
        System.out.println(pq.poll());
    }

//    F5,F4,F3,D6

//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        String[] moves = scan.nextLine().split(",");
//        boolean isBlack = false;
//        // init board: 1 = white / -1 = black
//        int[][] board = new int[8][8];
//        initBoard(board);
//        for (int i = 0; i < moves.length; i++) {
//            isBlack = !isBlack;
//            // check curr move
//            String currMove = moves[i];
//            if (currMove.equals("00")) {
//                if (checkAllValidMove(board, isBlack)) {
//                    continue;
//                } else {
//                    System.out.println("ERROR " + String.valueOf(i + 1) + ":00");
//                    return;
//                }
//            } else {
//                int x = currMove.charAt(1) - '0' - 1;
//                int y = currMove.charAt(0) - 'A';
//                if (checkMoveAndUpdate(board, x, y, isBlack)) {
//                    //printBoard(board);
//                    continue;
//                } else {
//                    System.out.println("ERROR " + String.valueOf(i + 1) + ":" + currMove);
//                    return;
//                }
//            }
//        }
//        int countBlack = 0;
//        int countWhite = 0;
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[0].length; j++) {
//                if (board[i][j] == 1) {
//                    countWhite++;
//                } else if (board[i][j] == -1) {
//                    countBlack++;
//                }
//            }
//        }
//        System.out.println("OK " + countBlack + ":" + countWhite);
//    }
//
//    public static void printBoard(int[][] board) {
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[0].length; j++) {
//                System.out.print(board[i][j] + "\t ");
//            }
//            System.out.println();
//        }
//        System.out.println("//===============");
//    }
//
//    public static boolean checkAllValidMove(int[][] board, boolean isBlack) {
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[0].length; j++) {
//                if (checkMove(board, i, j, isBlack)) {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
//
//    public static boolean checkMove(int[][] board, int x, int y, boolean isBlack) {
//        if (x < 0 || y < 0 || x > board.length || y > board[0].length || board[x][y] != 0) {
//            return false;
//        }
//        boolean isValid = false;
//        int host = isBlack ? -1 : 1;
//        int oppo = isBlack ? 1 : -1;
//        // upper left
//        int tmpX = x - 1;
//        int tmpY = y - 1;
//        while (isColor(board, tmpX, tmpY, oppo)) {
//            tmpX--;
//            tmpY--;
//        }
//        if (isColor(board, tmpX, tmpY, host) && tmpX != x - 1 && tmpY != y - 1) {
//            isValid = true;
//        }
//        // upper
//        tmpX = x - 1;
//        tmpY = y;
//        while (isColor(board, tmpX, tmpY, oppo)) {
//            tmpX--;
//        }
//        if (isColor(board, tmpX, tmpY, host) && tmpX != x - 1) {
//            isValid = true;
//        }
//        // upper right
//        tmpX = x - 1;
//        tmpY = y + 1;
//        while (isColor(board, tmpX, tmpY, oppo)) {
//            tmpX--;
//            tmpY++;
//        }
//        if (isColor(board, tmpX, tmpY, host) && tmpX != x - 1 && tmpY != y + 1) {
//            isValid = true;
//        }
//        // left
//        tmpX = x;
//        tmpY = y - 1;
//        while (isColor(board, tmpX, tmpY, oppo)) {
//            tmpY--;
//        }
//        if (isColor(board, tmpX, tmpY, host) && tmpY != y - 1) {
//            isValid = true;
//        }
//        // right
//        tmpX = x;
//        tmpY = y + 1;
//        while (isColor(board, tmpX, tmpY, oppo)) {
//            tmpY++;
//        }
//        if (isColor(board, tmpX, tmpY, host) && tmpY != y + 1) {
//            isValid = true;
//        }
//        // bottom left
//        tmpX = x + 1;
//        tmpY = y - 1;
//        while (isColor(board, tmpX, tmpY, oppo)) {
//            tmpX++;
//            tmpY--;
//        }
//        if (isColor(board, tmpX, tmpY, host) && tmpX != x + 1 && tmpY != y - 1) {
//            isValid = true;
//        }
//        // bottom
//        tmpX = x + 1;
//        tmpY = y;
//        while (isColor(board, tmpX, tmpY, oppo)) {
//            tmpX++;
//        }
//        if (isColor(board, tmpX, tmpY, host) && tmpX != x + 1) {
//            isValid = true;
//        }
//        // bottom right
//        tmpX = x + 1;
//        tmpY = y + 1;
//        while (isColor(board, tmpX, tmpY, oppo)) {
//            tmpX++;
//            tmpY++;
//        }
//        if (isColor(board, tmpX, tmpY, host) && tmpX != x + 1 && tmpY != y + 1) {
//            isValid = true;
//        }
//
//        return isValid;
//    }
//
//    public static boolean checkMoveAndUpdate(int[][] board, int x, int y, boolean isBlack) {
//        if (x < 0 || y < 0 || x > board.length || y > board[0].length || board[x][y] != 0) {
//            return false;
//        }
//        boolean isValid = false;
//        int host = isBlack ? -1 : 1;
//        int oppo = isBlack ? 1 : -1;
//        // upper left
//        int tmpX = x - 1;
//        int tmpY = y - 1;
//        while (isColor(board, tmpX, tmpY, oppo)) {
//            tmpX--;
//            tmpY--;
//        }
//        if (isColor(board, tmpX, tmpY, host) && tmpX != x - 1 && tmpY != y - 1) {
//            isValid = true;
//            // update board
//            int ttx = x - 1;
//            int tty = y - 1;
//            while (ttx > tmpX && tty > tmpY) {
//                board[ttx][tty] = host;
//                ttx--;
//                tty--;
//            }
//        }
//        // upper
//        tmpX = x - 1;
//        tmpY = y;
//        while (isColor(board, tmpX, tmpY, oppo)) {
//            tmpX--;
//        }
//        if (isColor(board, tmpX, tmpY, host) && tmpX != x - 1) {
//            isValid = true;
//            // update board
//            int ttx = x - 1;
//            int tty = y;
//            while (ttx > tmpX) {
//                board[ttx][tty] = host;
//                ttx--;
//            }
//        }
//        // upper right
//        tmpX = x - 1;
//        tmpY = y + 1;
//        while (isColor(board, tmpX, tmpY, oppo)) {
//            tmpX--;
//            tmpY++;
//        }
//        if (isColor(board, tmpX, tmpY, host) && tmpX != x - 1 && tmpY != y + 1) {
//            isValid = true;
//            // update board
//            int ttx = x - 1;
//            int tty = y + 1;
//            while (ttx > tmpX && tty < tmpY) {
//                board[ttx][tty] = host;
//                ttx--;
//                tty++;
//            }
//        }
//        // left
//        tmpX = x;
//        tmpY = y - 1;
//        while (isColor(board, tmpX, tmpY, oppo)) {
//            tmpY--;
//        }
//        if (isColor(board, tmpX, tmpY, host) && tmpY != y - 1) {
//            isValid = true;
//            // update board
//            int ttx = x;
//            int tty = y - 1;
//            while (tty > tmpY) {
//                board[ttx][tty] = host;
//                tty--;
//            }
//        }
//        // right
//        tmpX = x;
//        tmpY = y + 1;
//        while (isColor(board, tmpX, tmpY, oppo)) {
//            tmpY++;
//        }
//        if (isColor(board, tmpX, tmpY, host) && tmpY != y + 1) {
//            isValid = true;
//            // update board
//            int ttx = x;
//            int tty = y + 1;
//            while (tty > tmpY) {
//                board[ttx][tty] = host;
//                tty++;
//            }
//        }
//        // bottom left
//        tmpX = x + 1;
//        tmpY = y - 1;
//        while (isColor(board, tmpX, tmpY, oppo)) {
//            tmpX++;
//            tmpY--;
//        }
//        if (isColor(board, tmpX, tmpY, host) && tmpX != x + 1 && tmpY != y - 1) {
//            isValid = true;
//            // update board
//            int ttx = x + 1;
//            int tty = y - 1;
//            while (ttx < tmpX && tty > tmpY) {
//                board[ttx][tty] = host;
//                ttx++;
//                tty--;
//            }
//        }
//        // bottom
//        tmpX = x + 1;
//        tmpY = y;
//        while (isColor(board, tmpX, tmpY, oppo)) {
//            tmpX++;
//        }
//        if (isColor(board, tmpX, tmpY, host) && tmpX != x + 1) {
//            isValid = true;
//            // update board
//            int ttx = x + 1;
//            int tty = y;
//            while (ttx < tmpX) {
//                board[ttx][tty] = host;
//                ttx++;
//            }
//        }
//        // bottom right
//        tmpX = x + 1;
//        tmpY = y + 1;
//        while (isColor(board, tmpX, tmpY, oppo)) {
//            tmpX++;
//            tmpY++;
//        }
//        if (isColor(board, tmpX, tmpY, host) && tmpX != x + 1 && tmpY != y + 1) {
//            isValid = true;
//            // update board
//            int ttx = x + 1;
//            int tty = y + 1;
//            while (ttx < tmpX && tty < tmpY) {
//                board[ttx][tty] = host;
//                ttx++;
//                tty++;
//            }
//        }
//
//        if (isValid) {
//            board[x][y] = host;
//        }
//
//        return isValid;
//    }
//
//    public static boolean isColor(int[][] board, int x, int y, int color) {
//        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) {
//            return false;
//        }
//        return board[x][y] == color;
//    }
//
//    public static void initBoard(int[][] board) {
//        board[3][3] = 1;
//        board[3][4] = -1;
//        board[4][3] = -1;
//        board[4][4] = 1;
//    }
}
