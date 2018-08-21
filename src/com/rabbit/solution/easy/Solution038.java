package com.rabbit.solution.easy;

public class Solution038 {
    public static String countAndSay(int n) {
        String str = "1";
        for (int i = 1; i < n; i++) {
            str = nextLine(str);
        }

        return str;
    }

    public static String nextLine(String line) {
        if (line.isEmpty()) {
            return null;
        }
        int count = 0;
        char curr = line.charAt(0);
        String result = "";
        for(int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == curr) {
                count++;
            } else  {
                result = result + count + curr;
                curr = line.charAt(i);
                count = 1;
            }
        }

        result = result + count + curr;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(4));
    }
}
