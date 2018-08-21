package com.rabbit.solution.easy;

public class Solution167 {
    public static int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        while (i <= j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                int[] result = { i + 1, j + 1};
                return result;
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        int[] input = {2,7,11,15};
        System.out.println(twoSum(input, 9));
    }
}
