package com.rabbit.solution.medium;

import java.util.*;

public class Solution127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) {
            return 0;
        }
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int count = 1;
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                String word = queue.poll();
                for (int j = 0; j < word.length(); j++) {
                    for (char k = 'a'; k < 'z'; k++) {
                        String newWord = word.substring(0, j) + k + word.substring(j + 1);
                        if (newWord.equals(endWord)) {
                            return ++count;
                        }
                        if (set.contains(newWord) && !visited.contains(newWord)) {
                            queue.offer(newWord);
                            visited.add(newWord);
                        }
                    }
                }
            }
            count++;
        }
        return 0;
    }
}
