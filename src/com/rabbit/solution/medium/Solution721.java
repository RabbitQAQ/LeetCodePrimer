package com.rabbit.solution.medium;

import java.util.*;

public class Solution721 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> rootMap = new HashMap<>();
        Map<String, String> nameMap = new HashMap<>();
        Map<String, TreeSet<String>> resMap = new HashMap<>();
        for (List<String> account : accounts) {
            for (int i = 1; i < account.size(); i++) {
                rootMap.put(account.get(i), account.get(i));
                nameMap.put(account.get(i), account.get(0));
            }
        }
        for (List<String> account : accounts) {
            String tmpRoot = find(account.get(1), rootMap);
            for (int i = 2; i < account.size(); i++) {
                rootMap.put(find(account.get(i), rootMap), tmpRoot);
            }
        }
        for (List<String> account : accounts) {
            for (int i = 1; i < account.size(); i++) {
                String tmpRoot = find(account.get(i), rootMap);
                if (!resMap.containsKey(tmpRoot)) {
                    resMap.put(tmpRoot, new TreeSet<>());
                }
                resMap.get(tmpRoot).add(account.get(i));
            }
        }

        List<List<String>> res = new ArrayList<>();
        for (TreeSet<String> set : resMap.values()) {
            List<String> tmp = new ArrayList<>(set);
            tmp.add(0, nameMap.get(tmp.get(0)));
            res.add(tmp);
        }

        return res;
    }

    public String find(String s, Map<String, String> map) {
        if (map.get(s).equals(s)) {
            return s;
        } else {
            return find(map.get(s), map);
        }
    }
}
