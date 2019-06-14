package com.rabbit.solution.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution399 {
    static Map<String, Map<String, Double>> dict = new HashMap<>();

    public static double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        double[] res = new double[queries.length];
        for (int i = 0; i < equations.length; i++) {
            String up = equations[i][0];
            String down = equations[i][1];
            if (dict.containsKey(up)) {
                dict.get(up).put(down, values[i]);
            } else {
                Map<String, Double> tmp = new HashMap<>();
                tmp.put(down, values[i]);
                dict.put(up, tmp);
            }
            if (dict.containsKey(down)) {
                dict.get(down).put(up, 1.0 / values[i]);
            } else {
                Map<String, Double> tmp = new HashMap<>();
                tmp.put(up, 1.0 / values[i]);
                dict.put(down, tmp);
            }
        }

        for (int i = 0; i < queries.length; i++) {
            Set<String> visited = new HashSet<>();
            double t;
            if (dict.containsKey(queries[i][0]) && queries[i][0].equals(queries[i][1]))
                t = 1.0;
            else
                t = helper(queries[i][0], queries[i][1], visited);
            res[i] = t;
        }

        return res;
    }

    public static Double helper(String up, String down, Set<String> visited) {
        if (!dict.containsKey(up))
            return -1.0;
        if (dict.get(up).containsKey(down))
            return dict.get(up).get(down);
        for (Map.Entry<String, Double> entry : dict.get(up).entrySet()) {
            if (visited.contains(entry.getKey()))
                continue;
            visited.add(entry.getKey());
            double t = helper(entry.getKey(), down, visited);
            if (t != -1.0)
                return t * entry.getValue();
        }

        return -1.0;
    }

//    public static String[] makePair(String i, String j) {
//        String[] strs = new String[2];
//        strs[0] = i;
//        strs[1] = j;
//        return strs;
//    }

    public static void main(String[] args) {
        String[][] teststr = {{"a", "b"}};
        double[] values = {0.5};
        String[][] testqueries = {{"a", "b"}, {"b", "a"}, {"a", "c"}, {"x", "y"}};
        double[] res = calcEquation(teststr, values, testqueries);
        System.out.println(res);
    }
}
