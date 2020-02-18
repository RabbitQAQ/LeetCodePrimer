package com.rabbit.solution.hard;

import java.util.*;

public class Solution126 {

    // O(K*N*D + N*logN) n*logn = 2^L * L = L * M     L is the shortest path and equals to logN
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.size() == 0) {
            return new ArrayList<>();
        }
        Set<String> wordDict = new HashSet<>(wordList);
        if (!wordDict.contains(endWord)) {
            return new ArrayList<>();
        }
        Map<String, List<String>> graph = new HashMap<>();
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        queue.offer(beginWord);
        visited.add(beginWord);

        while (!queue.isEmpty()) {
            int n = queue.size();
            boolean findEnd = false;
            wordDict.removeAll(visited);
            Set<String> dup = new HashSet<>();
            for (int i = 0; i < n; i++) {
                String curr = queue.poll();
                for (int j = 0; j < curr.length(); j++) {
                    char[] charArray = curr.toCharArray();
                    for (char c = 'a'; c < 'z'; c++) {
                        charArray[j] = c;
                        String newStr = new String(charArray);
                        if (wordDict.contains(newStr)) {
                            visited.add(newStr);
                            if (!dup.contains(newStr))
                                queue.offer(newStr);
                            dup.add(newStr);
                            graph.putIfAbsent(curr, new ArrayList<>());
                            graph.get(curr).add(newStr);
                        }
                        if (newStr.equals(endWord)) {
                            findEnd = true;
                        }
                    }
                }
            }

            if (findEnd) {
                break;
            }
        }
        System.out.println(graph.toString());
        List<List<String>> res = new ArrayList<>();
        LinkedList<String> tmp = new LinkedList<>();
        tmp.add(beginWord);
        addPath(beginWord, endWord, graph, tmp, res);
        return res;
    }

    public static void addPath(String startWord, String endWord, Map<String, List<String>> graph, LinkedList<String> tmp, List<List<String>> res) {
        if (startWord.equals(endWord)) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        if (graph.containsKey(startWord)) {
            for (String neighbor : graph.get(startWord)) {
                tmp.add(neighbor);
                addPath(neighbor, endWord, graph, tmp, res);
                tmp.removeLast();
            }
        }

    }

    public static void main(String[] args) {
        System.out.println(findLadders("red", "tax", new ArrayList<String>(Arrays.asList("ted", "tex","red","tax","tad","den","rex","pee"))));
    }
}
