package com.rabbit.solution.easy;

public class Solution427 {
    // Definition for a QuadTree node.
    static class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {}

        public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
            val = _val;
            isLeaf = _isLeaf;
            topLeft = _topLeft;
            topRight = _topRight;
            bottomLeft = _bottomLeft;
            bottomRight = _bottomRight;
        }
    };

    public static Node construct(int[][] grid) {
        if (grid.length == 0) {
            return null;
        }
        Node res = new Node();
        if (check(grid, 0, 0, grid.length - 1, grid.length - 1)) {
            res.isLeaf = true;
            res.val = grid[0][0] != 0;
            return res;
        } else {
            res.isLeaf = false;
            res.val = false; // 存疑
        }
        res.topLeft = construct(divide(grid, 0));
        res.topRight = construct(divide(grid, 1));
        res.bottomLeft = construct(divide(grid, 2));
        res.bottomRight = construct(divide(grid, 3));


        return res;
    }

    public static int[][] divide(int[][] grid, int part) {
        int n = grid.length;
        if (n == 1) {
            return new int[0][0];
        }
        int[][] res = new int[n / 2][n / 2];
        int x1 = 0, y1 = 0, x2 = 0, y2 = 0;
        switch (part) {
            case 0 : x1 = 0; y1 = 0; x2 = (n - 1) / 2; y2 = (n - 1) / 2; break;
            case 1 : x1 = 0; y1 = n / 2; x2 = (n - 1) / 2; y2 = n - 1; break;
            case 2 : x1 = n / 2; y1 = 0; x2 = n - 1; y2 = (n - 1) / 2; break;
            case 3 : x1 = n / 2; y1 = n / 2; x2 = n - 1; y2 = n - 1; break;
        }

        for (int i = x1, i2 = 0; i <= x2; i++) {
            for (int j = y1, j2 = 0; j <= y2; j++) {
                res[i2][j2] = grid[i][j];
                j2++;
            }
            i2++;
        }

        return res;
    }

    public static boolean check(int[][] grid, int x1, int y1, int x2, int y2) {
        int num = grid[x1][y1];
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                if (num != grid[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        int[][] testcase = new int[4][4];
        for (int i = 0; i < testcase.length; i++) {
            for (int j = 0; j < testcase.length; j++) {
                testcase[i][j] = 0;
            }
        }

        testcase[1][2] = 1;
        testcase[1][3] = 1;
        testcase[2][2] = 1;
        testcase[2][3] = 1;

        Node res = construct(testcase);
        System.out.println(res);
    }
}
