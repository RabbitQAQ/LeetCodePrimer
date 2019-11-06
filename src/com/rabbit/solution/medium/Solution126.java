package com.rabbit.solution.medium;

public class Solution126 {
    /*
    这题能用二分来做的原因其实仅仅是因为我们将越界的数视为负无穷，并且peak一定存在。
    因此我们无论往哪一边走，都一定能够找到一个peak
    假设mid大于mid+1，那么要么mid自身是peak，要么mid左边一定有一个peak（因为mid左边要么更大，增大到边缘仍为peak，要么更小，那么可以让mid成为peak，题目给出了相邻不可能相等的限制）
    而假设mid小于mid+1，那么mid本身不可能成为peak，但同理，mid右边至少存在一个peak。

    基于以上思考，算法中要注意的是left和right的赋值，首先right赋值时不能为mid-1，因为mid自身仍然可能是peak，但是left的情况则不然，可以直接mid+1
    while的条件也需要更改，因为right会等于mid，所以需要left<right而不是left<=right
     */
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
