package com.rabbit.solution.medium;

import com.rabbit.solution.utils.ListNode;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class Solution311 {

    class Pair {
        public int index;
        public int value;
        Pair(int i, int v) {
            this.index = i;
            this.value = v;
        }
    }

    public int[][] multiply(int[][] A, int[][] B) {
        List<List<Pair>> expression = new ArrayList<>();
        int[][] res = new int[A[0].length][B.length];

        for (int i = 0; i < A.length; i++) {
            List<Pair> tmp = new ArrayList<>();
            for (int j = 0; j < A[i].length; j++) {
                if (A[i][j] != 0)
                    tmp.add(new Pair(j, A[i][j]));
            }
            expression.add(tmp);
        }

        for (int i = 0; i < expression.size(); i++) {
            List<Pair> tmp = expression.get(i);

            for (int j = 0; j < B[0].length; j++) {
                int sum = 0;
                for (int z = 0; z < tmp.size(); z++) {
                    sum += tmp.get(z).value * B[tmp.get(z).index][j];
                }
                res[i][j] = sum;
            }
        }

        return res;
    }

    public static void main(String[] args) {

    }
}
