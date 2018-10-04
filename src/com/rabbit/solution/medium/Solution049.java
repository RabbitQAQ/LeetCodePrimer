package com.rabbit.solution.medium;

import java.util.*;

public class Solution049 {
    // 这种方法也很tricky
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();
        Set<String> tools = new HashSet<>();
        for (int i = 0; i < strs.length; i++) {
            char[] temp = strs[i].toCharArray();
            Arrays.sort(temp);
            String tempStr = new String(temp);
            if (tools.add(tempStr)) {
                List<String> temp2 = new ArrayList<>();
                temp2.add(strs[i]);
                res.put(tempStr, temp2);
            } else {
                res.get(tempStr).add(strs[i]);
            }
        }

        return new ArrayList<>(res.values());
    }

    // 这种傻逼方法已经超时了
    public static List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> hashmap = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            boolean flag = false;
            for (Map.Entry<String, List<String>> entry : hashmap.entrySet()) {
                if (isAnagrams(entry.getKey(), strs[i])) {
                    entry.getValue().add(strs[i]);
                    flag = true;
                }
            }
            if (!flag) {
                List<String> temp = new ArrayList<>();
                temp.add(strs[i]);
                hashmap.put(strs[i], temp);
            }
        }

        return new ArrayList<>(hashmap.values());
    }

    public static boolean isAnagrams(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        int[] hash = new int[26];
        for (int i = 0; i < str1.length(); i++) {
            hash[str1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < str2.length(); i++) {
            if (--hash[str2.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (hash[i] != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String[] str = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(str));
    }
}
