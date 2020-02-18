package com.rabbit.solution.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution212 {
    class TrieNode {
        Map<Character, TrieNode> children;
        String str;
        boolean isWord;
        public TrieNode() {
            children = new HashMap<>();
        }
    }

    TrieNode root;

    public List<String> findWords(char[][] board, String[] words) {
        if (board.length == 0) {
            return new ArrayList<>();
        }
        root = new TrieNode();
        for (int i = 0; i < words.length; i++) {
            add(words[i]);
        }

        List<String> res = new ArrayList<>();
        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (root.children.containsKey(board[i][j])) {
                    search(board, visited, i, j, root, res);
                }
            }
        }

        return res;
    }

    public void add(String word) {
        TrieNode tmp = root;
        for (char c : word.toCharArray()) {
            if (!tmp.children.containsKey(c)) {
                tmp.children.put(c, new TrieNode());
            }
            tmp = tmp.children.get(c);
        }
        tmp.str = word;
        tmp.isWord = true;
    }

    public void search(char[][] board, boolean[][] visited, int x, int y, TrieNode root, List<String> res) {
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || !root.children.containsKey(board[x][y]) || visited[x][y]) {
            return;
        }
        TrieNode child = root.children.get(board[x][y]);
        if (child.isWord) {
            res.add(child.str);
            child.isWord = false;
            child.str = null;
        }
        visited[x][y] = true;
        int[][] dir = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] d : dir) {
            search(board, visited, x + d[0], y + d[1], child, res);
        }
        visited[x][y] = false;
    }
}
