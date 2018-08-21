package com.rabbit.solution.easy;

public class Solution026 {
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int available = 0;
        int current = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (current != nums[i]) {
                nums[available] = nums[i - 1];
                current = nums[i];
                available++;
            }
        }
        nums[available] = current;
        available++;

        return available;
    }

    public static void main(String[] args) {
        int[] test = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(test));
        for (int i = 0; i < test.length; i++) {
            System.out.print(test[i]);
        }
    }
}
