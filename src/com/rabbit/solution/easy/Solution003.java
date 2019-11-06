package com.rabbit.solution.easy;

import java.util.HashMap;
import java.util.Map;

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
            // 这个其实也就是为了=0这个条件能成立
            hashMap[s.charAt(i)] = i + 1;
        }

        return res;
    }

    public static int lengthOfLongestSubstring1(String s) {
        int res = 0;
        int[] hashMap = new int[256];
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            // 这句里的第二个判断条件要思考  一个数尽管已经出现过了，但是当他再次出现时，需要再次计算是否可用
            if (hashMap[s.charAt(i)] == 0 || hashMap[s.charAt(i)] < left - 1) {
                // 12行的+1和16行的+1也都要思考一下
                res = Math.max(res, i - left);
            } else {
                left = hashMap[s.charAt(i)];
                res = Math.max(res, i - left);
            }
            // 这个其实也就是为了=0这个条件能成立
            hashMap[s.charAt(i)] = i;
        }

        return res;
    }

    public static int lengthOfLongestSubstring3(String s) {
        int left = 0;
        int right = 0;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (right < s.length()) {
            char curr = s.charAt(right);
            if (!map.containsKey(curr) || map.get(curr) <= left) {
                max = Math.max(max, right - left + 1);
            } else {
                left = map.get(curr);
            }
            map.put(curr, right + 1);
            right++;
        }

        return max;
    }

    public static int lengthOfLongestSubstring4(String s) {
        int left = 0;
        int right = 0;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (right < s.length()) {
            char curr = s.charAt(right);
            if (map.containsKey(curr) && map.get(curr) >= left) {
                left = map.get(curr);
            }
            max = Math.max(max, right - left + 1);
            map.put(curr, right + 1);
            right++;
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring4("abba"));
    }
}
