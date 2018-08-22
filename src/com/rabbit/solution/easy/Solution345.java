package com.rabbit.solution.easy;

public class Solution345 {
    public String reverseVowels(String s) {
        char[] temp = s.toCharArray();
        char[] res = new char[temp.length];
        int count = 0;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == 'a' || temp[i] == 'e' || temp[i] == 'i' || temp[i] == 'o' || temp[i] == 'u'
            || temp[i] == 'A' || temp[i] == 'E' || temp[i] == 'I' || temp[i] == 'O' || temp[i] == 'U') {
                temp[count] = temp[i];
                count++;
            }
        }
        for (int i = 0; i < res.length; i++) {
            char curr = s.charAt(i);
            switch (curr) {
                case 'A':;
                case 'E':;
                case 'I':;
                case 'O':;
                case 'U':;
                case 'a':;
                case 'e':;
                case 'i':;
                case 'o':;
                case 'u':res[i] = temp[--count];break;
                default:res[i] = s.charAt(i);
            }

        }

        return new String(res);
    }

    public static void main(String[] args) {

    }
}
