package com.rabbit.solution.others;

import java.util.*;

public class SolutionTest {
    public static void main(String[] args) {
//        System.out.println(solution(new String[][] {
//                {"Bart", "brother", "Lisa"},
//                {"Bart", "son", "Homer"},
//                {"Marge", "wife", "Homer"},
//                {"Lisa", "daughter", "Homer"},
//                {"Lisa", "sister", "Bart"},
//        }, "Bart", "Homer"));
//        LinkedList<Integer> list = new LinkedList<>();
        System.out.println(minSubArrayLen(7, new int[] {2,3,1,2,4,3}));

    }

    public static List<String> solution(String[][] input, String start, String end) {
        Map<String, Map<String, String>> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < input.length; i++) {
            map.putIfAbsent(input[i][0], new HashMap<>());
            map.get(input[i][0]).put(input[i][2], input[i][1]);
        }
        List<String> res = new ArrayList<>();
        helper(map, start, end, res, "", set);
        return res;
    }

    public static void helper(Map<String, Map<String, String>> map, String start, String end, List<String> res, String tmp, Set<String> set) {
        if (start.equals(end)) {
            res.add(tmp + end);
            return;
        }
        set.add(start);
        for (Map.Entry<String, String> entry : map.get(start).entrySet()) {
            if (!set.contains(entry.getKey())) {
                helper(map, entry.getKey(), end, res, tmp + start + " " + entry.getValue() + " ", set);
            }
        }
    }

    public static int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int sum = nums[0];
        int minLength = Integer.MAX_VALUE;
        while (right < nums.length) {
            if (sum < s) {
                right++;
                if (right < nums.length) {
                    sum += nums[right];
                }
            } else {
                minLength = Math.min(minLength, right - left - 1);
                sum -= nums[left++];
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
