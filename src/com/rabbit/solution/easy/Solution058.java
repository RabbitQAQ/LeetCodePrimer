package com.rabbit.solution.easy;

public class Solution058 {
    public static int lengthOfLastWord(String s) {
        String[] result = s.split(" ");
        if (result.length == 0) {
            return 0;
        }

        return result[result.length - 1].length();
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World"));
    }
}
