package com.rabbit.solution.others;


import java.util.*;

public class SolutionWish {
    public static void main(String[] args) {
        List<List<String>> testList = new ArrayList<>();
        String[][] fuck = new String[][] {
                {"Bart", "brother", "Lisa"},
                {"Bart", "friend", "Lisa"},
                {"Bart", "son", "Homer"},
                {"Marge", "wife", "Homer"},
                {"Lisa", "daughter", "Homer"},
                {"Homer", "father", "Lisa"}
        };
        System.out.println(solution(fuck, "Bart", "Homer"));
    }

    public static List<String> solution(String[][] relationship, String name, String endName) {
        Map<String, Map<String, List<String>>> relationMap = new HashMap<>();
        for (int i = 0; i < relationship.length; i++) {
            String[] curr = relationship[i];
            relationMap.putIfAbsent(curr[0], new HashMap<>());
            if (!relationMap.get(curr[0]).containsKey(curr[2])) {
                relationMap.get(curr[0]).put(curr[2], new ArrayList<>());
            }
            relationMap.get(curr[0]).get(curr[2]).add(curr[1]);
        }
        List<String> res = new ArrayList<>();
        helper(relationMap, name, endName, new HashSet<>(), "", res);
        return res;
    }

    public static void helper(Map<String, Map<String, List<String>>> relationMap, String name, String endName, Set<String> visited, String tmp, List<String> res) {
        if (name.equals(endName)) {
            tmp = tmp + endName;
            res.add(tmp);
            return;
        }
        if (relationMap.containsKey(name) && !visited.contains(name)) {
            visited.add(name);
            for (Map.Entry<String, List<String>> entry : relationMap.get(name).entrySet()) {
                for (String relation : entry.getValue()) {
                    helper(relationMap, entry.getKey(), endName, visited, tmp + name + " " + relation + " ", res);
                }
            }
            visited.remove(name);
        }

    }
}
