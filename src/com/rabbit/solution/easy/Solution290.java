package com.rabbit.solution.easy;

import java.util.ArrayList;
import java.util.List;

public class Solution290 {
    public static boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }
        List<String> existWords = new ArrayList<>();
        String[] wordArray = new String[26];
        for (int i = 0; i < words.length; i++) {
            if (wordArray[pattern.charAt(i) - 'a'] == null) {
                wordArray[pattern.charAt(i) - 'a'] = words[i];
                for (String exist : existWords) {
                    if (words[i].equals(exist)) {
                        return false;
                    }
                }
                existWords.add(words[i]);
            } else {
                if (!wordArray[pattern.charAt(i) - 'a'].equals(words[i])) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        //String[] wordArray = new String[26];
        //System.out.println(wordArray[0]);
        System.out.println(wordPattern("abc", "dog cat ct"));
    }
}
