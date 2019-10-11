package com.rabbit.solution.others;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class SolutionWangYi002 {

    public static int count = 0;
    public static Map<Integer, Integer> indexMap = new HashMap<>();

    public static void merge(int[] array, int start, int mid, int end, int[] helper) {
        int i = start;
        int j = mid + 1;
        int index = 0;
        while (i <= mid && j <= end) {
            if (array[i] > array[j]) {
                for (int k = i; k <= mid; k++) {
                    count += Math.abs(indexMap.get(array[k]) - indexMap.get(array[j]));
                }
                helper[index++] = array[j++];
            } else {
                helper[index++] = array[i++];
            }
        }
        while (i <= mid) {
            helper[index] = array[i];
            index++;
            i++;
        }
        while (j <= end) {
            helper[index] = array[j];
            index++;
            j++;
        }
        i = 0;
        while (i < index) {
            array[start + i] = helper[i];
            i++;
        }

    }


    public static void mergeAndSolve(int[] array, int start, int end, int[] helper) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        mergeAndSolve(array, start, mid, helper);
        mergeAndSolve(array, mid + 1, end, helper);
        merge(array, start, mid, end, helper);
    }

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        int[] array = new int[num];
        for (int i = 0; i < num; i++) {
            array[i] = scan.nextInt();
            indexMap.put(array[i], i);
        }
        mergeAndSolve(array, 0, num - 1, new int[num]);
        System.out.println(count);
    }
//    public static boolean isPerfect(int[] array, int left, int right) {
//        int sum = 0;
//        for (int i = left; i <= right; i++) {
//            if (array[i] < sum)
//                return false;
//            sum += array[i];
//        }
//        return true;
//    }
//    public static int res = Integer.MAX_VALUE;
//
//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        int num = scan.nextInt();
//        for (int k = 0; k < num; k++) {
//            int A = scan.nextInt();
//            int B = scan.nextInt();
//            int p = scan.nextInt();
//            int q = scan.nextInt();
//            res = Integer.MAX_VALUE;
//            dfs(A, B, p, q, 0);
//            System.out.println(res);
//        }
//    }
//
//    public static void dfs(int A, int B, int p, int q, int count) {
//        if (A + p >= B) {
//            res = Math.min(res, count + 1);
//            return;
//        } else {
//            dfs(A + p, B, p, q, count + 1);
//            dfs(A, B, p * q, q, count + 1);
//        }
//    }
}
