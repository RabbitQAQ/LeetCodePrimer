package com.rabbit.solution.medium;

import com.rabbit.solution.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class Solution054 {
    public static List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        int z = 0, x = matrix.length - 1, y = matrix[0].length - 1;
        while (x >= z && y >= z) {
            res.addAll(outer(matrix, z, x, y));
            x--;
            y--;
            z++;
        }

        return res;
    }

    public static List<Integer> outer(int[][] matrix, int z,int x, int y) {
        int size = (y - z + x) * 2;
        List<Integer> res = new ArrayList<>();
        int xc = z, yc = z;
        if (y == z) {
            while (xc <= x) {
                res.add(matrix[xc][yc]);
                xc++;
            }
            return res;
        } else if (x == z) {
            while (yc <= y) {
                res.add(matrix[xc][yc]);
                yc++;
            }
            return res;
        } else {
            while (yc <= y) {
                res.add(matrix[xc][yc]);
                yc++;
            }
            yc--;
            if (x - z > 1) {
                while (xc < x - 1) {
                    xc++;
                    res.add(matrix[xc][yc]);
                }
                xc++;
                while (yc >= z) {
                    res.add(matrix[xc][yc]);
                    yc--;
                }
                yc++;
                xc--;
                while (xc > z) {
                    res.add(matrix[xc][yc]);
                    xc--;
                }
            } else if (x - z > 0) {
                xc++;
                while (yc >= z) {
                    res.add(matrix[xc][yc]);
                    yc--;
                }
                yc++;
            }

        }

        return res;
    }

    public static void main(String[] args) {
        int[][] testcase = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}};
        //System.out.println(outer(testcase, 1, 1, 1));
        System.out.println(spiralOrder(testcase));
    }
}
