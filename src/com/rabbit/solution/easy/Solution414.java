package com.rabbit.solution.easy;

public class Solution414 {
    // 写的有点垃圾  还好效率还行
    public static int thirdMax(int[] nums) {
        // maxs[0]最大
        int[] maxs = new int[3];
        maxs[0] = Integer.MIN_VALUE;
        maxs[1] = Integer.MIN_VALUE;
        maxs[2] = Integer.MIN_VALUE;
        int flag = 0;
        boolean flag0 = false, flag1 = false, flag2 = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= maxs[0]) {
                if (nums[i] == maxs[0]){
                    if (!flag0 && maxs[0] == Integer.MIN_VALUE) {
                        flag0 = true;
                    } else {
                        continue;
                    }
                }
                maxs[2] = maxs[1];
                maxs[1] = maxs[0];
                maxs[0] = nums[i];
                flag++;
            } else if (nums[i] >= maxs[1]) {
                if (nums[i] == maxs[1]) {
                    if (!flag1 && maxs[1] == Integer.MIN_VALUE) {
                        flag1 = true;
                    } else {
                        continue;
                    }
                }
                maxs[2] = maxs[1];
                maxs[1] = nums[i];
                flag++;
            } else if (nums[i] >= maxs[2]) {
                if (nums[i] == maxs[2]) {
                    if (!flag2 && maxs[2] == Integer.MIN_VALUE) {
                        flag2 = true;
                    } else {
                        continue;
                    }
                }
                maxs[2] = nums[i];
                flag++;
            }
        }

        if (flag >= 3) {
            return maxs[2];
        } else {
            return maxs[0];
        }

    }

    public static void main(String[] args) {
        int[] array = {2,2,3,1};
        System.out.println(thirdMax(array));
    }
}
