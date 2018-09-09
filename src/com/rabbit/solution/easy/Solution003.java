package com.rabbit.solution.easy;

public class Solution003 {
    public static int lengthOfLongestSubstring(String s) {
        int res = 0;
        int[] hashMap = new int[256];
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            // 这句里的第二个判断条件要思考  一个数尽管已经出现过了，但是当他再次出现时，需要再次计算是否可用
            if (hashMap[s.charAt(i)] == 0 || hashMap[s.charAt(i)] < left) {
                // 12行的+1和16行的+1也都要思考一下
                res = Math.max(res, i - left + 1);
            } else {
                left = hashMap[s.charAt(i)];
            }
            hashMap[s.charAt(i)] = i + 1;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("tmmzuxt"));
    }
}
