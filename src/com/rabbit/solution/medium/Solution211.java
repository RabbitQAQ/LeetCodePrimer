package com.rabbit.solution.medium;

public class Solution211 {
    class TrieNode {
        char val;
        TrieNode[] children;
        boolean isWord;

        public TrieNode(char val) {
            this.val = val;
            this.children = new TrieNode[26];
            this.isWord = false;
        }
    }

    class WordDictionary {

        TrieNode root;

        /** Initialize your data structure here. */
        public WordDictionary() {
            this.root = new TrieNode('.');
        }

        /** Adds a word into the data structure. */
        public void addWord(String word) {
            TrieNode tmp = this.root;
            for (int i = 0; i < word.length(); i++) {
                char curr = word.charAt(i);
                if (tmp.children[curr - 'a'] != null) {
                    tmp = tmp.children[curr - 'a'];
                } else {
                    tmp.children[curr - 'a'] = new TrieNode(curr);
                    tmp = tmp.children[curr - 'a'];
                }
                if (i == word.length() - 1) {
                    tmp.isWord = true;
                }
            }
        }

        /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
        public boolean search(String word) {
            return helper(this.root, word);
        }

        public boolean helper(TrieNode root, String word) {
            TrieNode tmp = root;
            for (int i = 0; i < word.length(); i++) {
                char curr = word.charAt(i);
                if (curr == '.') {
                    for (int j = 0; j < tmp.children.length; j++) {
                        if (tmp.children[j] != null && helper(tmp.children[j], word.substring(i + 1))) {
                            return true;
                        }
                    }
                    return false;
                } else if (tmp.children[curr - 'a'] != null) {
                    tmp = tmp.children[curr - 'a'];
                } else {
                    return false;
                }
            }

            return tmp.isWord;
        }
    }

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
}
