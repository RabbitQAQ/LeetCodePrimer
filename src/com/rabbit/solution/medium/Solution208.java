package com.rabbit.solution.medium;

import java.util.Arrays;

public class Solution208 {
    class TrieNode {
        public boolean isLeaf;
        public TrieNode[] children;

        public TrieNode() {
            this.children = new TrieNode[26];
        }
    }

    class Trie {

        TrieNode root;

        /** Initialize your data structure here. */
        public Trie() {
            this.root = new TrieNode();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            TrieNode tmp = root;
            for (int i = 0; i < word.length(); i++) {
                char curr = word.charAt(i);
                if (tmp.children[curr - 'a'] == null) {
                    tmp.children[curr - 'a'] = new TrieNode();
                }
                if (i == word.length() - 1) {
                    tmp.children[curr - 'a'].isLeaf = true;
                }
                tmp = tmp.children[curr - 'a'];
            }
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            TrieNode tmp = root;
            for (int i = 0; i < word.length(); i++) {
                char curr = word.charAt(i);
                if (tmp.children[curr - 'a'] == null) {
                    return false;
                }
                tmp = tmp.children[curr - 'a'];
            }

            return tmp.isLeaf;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            TrieNode tmp = root;
            for (int i = 0; i < prefix.length(); i++) {
                char curr = prefix.charAt(i);
                if (tmp.children[curr - 'a'] == null) {
                    return false;
                }
                tmp = tmp.children[curr - 'a'];
            }

            return true;
        }
    }
}
