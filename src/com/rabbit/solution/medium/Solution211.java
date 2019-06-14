package com.rabbit.solution.medium;

public class Solution211 {
    static class WordDictionary {

        class TrieNode {
            TrieNode[] children;
            boolean isWord;
            TrieNode() {
                isWord = false;
                children = new TrieNode[26];
                for (TrieNode i : children)
                    i = null;
            }
        }

        TrieNode root;

        /** Initialize your data structure here. */
        public WordDictionary() {
            root = new TrieNode();
        }

        /** Adds a word into the data structure. */
        public void addWord(String word) {
            if (word == null || word.equals("")) {
                return;
            }
            TrieNode temp = root;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if (temp.children[index] == null)
                    temp.children[index] = new TrieNode();
                temp = temp.children[index];
            }
            temp.isWord = true;
        }

        /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
        public boolean search(String word) {
            return newSearch(word, 0, root);
        }

        public boolean newSearch(String word, int start, TrieNode startNode) {
            TrieNode temp = startNode;
            for (int i = start; i < word.length(); i++) {
                if (word.charAt(i) == '.') {
                    for (int j = 0; j < 26; j++) {
                        if (temp.children[j] != null) {
                            if (newSearch(word, i + 1, temp.children[j]))
                                return true;
                        }
                    }
                    return false;
                } else {
                    int index = word.charAt(i) - 'a';
                    if (temp.children[index] == null)
                        return false;
                    else
                        temp = temp.children[index];
                }
            }
            return temp.isWord;
        }
    }

    public static void main(String[] args) {
        WordDictionary test = new WordDictionary();
        test.addWord("add");
        //test.addWord("dad");
        //test.addWord("mad");
        System.out.println(test.search("."));
//        System.out.println(test.search("bad"));
//        System.out.println(test.search(".ad"));
//        System.out.println(test.search("b.."));
        System.out.println(test);

    }

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
}
