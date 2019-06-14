package com.rabbit.solution.algorithms;

// 基于下面这道题
// 在一个有重复的升序数组中找出target第一次出现的位置
// 有一个follow up是找出target的出现次数
// 其实就找到最左和最右减一下即可
public class BinarySearch {
    public static int solution(int[] array, int target) {
        int left = 0;
        int right = array.length;
        int pos = -1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                pos = mid;
                while (--mid >= 0) {
                    if (array[mid] == target)
                        pos = mid;
                }
                break;
            }
            if (array[mid] > target)
                right = mid - 1;
            else
                left = mid + 1;

        }

        return pos;
    }

    public static void main(String[] args) {
        int[] testcase = {1,2,2,2,2,2,3,4,5,6};
        System.out.println(solution(testcase, 2));
    }
}
