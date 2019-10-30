package com.rabbit.solution.medium;

import com.rabbit.solution.utils.Utils;

public class Solution075 {

    // 略微改进版，通过nums[i] == 0时的i++来代替原本if里面的i != p0(p2)条件
    /*
        注意，此处nums[i] == 2时不需要i++的原因是因为遍历方向是从左至右的
        即p0一定大于等于0的边界，在发生交换的时候一定已经遍历过到i为止的所有值，所以不需要担心有漏算的情况
        但是p2在交换之后，交换过去的值并没有被i遍历过，所以需要让i暂停一下，验证交换过去的那个值
     */
    public void sortColors2(int[] nums) {
        int p0 = 0;
        int p2 = nums.length - 1;
        for (int i = 0; i < p2 + 1; ) {
            if (nums[i] == 0) {
                swap(nums, p0++, i++);
            } else if (nums[i] == 2) {
                swap(nums, p2--, i);
            } else {
                i++;
            }
        }
    }

    public void sortColors(int[] nums) {
        int p0 = 0;
        int p2 = nums.length - 1;
        for (int i = 0; i < p2 + 1; ) {
            if (nums[i] == 0 && i != p0) {
                swap(nums, p0++, i);
            } else if (nums[i] == 2 && i != p2) {
                swap(nums, p2--, i);
            } else {
                i++;
            }
        }
    }

    public void swap(int[] nums, int p1, int p2) {
        int tmp = nums[p1];
        nums[p1] = nums[p2];
        nums[p2] = tmp;
    }
}
