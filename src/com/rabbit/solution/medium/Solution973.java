package com.rabbit.solution.medium;

import javax.sound.midi.Soundbank;
import java.util.Arrays;

public class Solution973 {
    int[][] points;

    public int[][] kClosest(int[][] points, int K) {
        this.points = points;
        quickSort(0, points.length - 1);
        return Arrays.copyOfRange(points, 0, K);
    }

    public void quickSort(int left, int right) {
        if (points.length < 2 || left >= right) {
            return;
        }
        int l = left + 1, r = right;
        int partition = calDistance(left);
        while (true) {
            while (l < r && calDistance(l) <= partition) {
                l++;
            }
            while (l <= r && calDistance(r) >= partition) {
                r--;
            }
            if (l >= r) {
                break;
            }
            swap(l, r);
        }
        swap(left, r);
        partition = r;
        quickSort(left, partition - 1);
        quickSort(partition + 1, right);
    }

    public int calDistance(int i) {
        return points[i][0] * points[i][0] + points[i][1] * points[i][1];
    }

    public void swap(int i, int j) {
        int tmpx = points[i][0];
        int tmpy = points[i][1];
        points[i][0] = points[j][0];
        points[i][1] = points[j][1];
        points[j][0] = tmpx;
        points[j][1] = tmpy;
    }

}
