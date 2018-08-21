package com.rabbit.solution.easy;

public class Solution067 {
    public static String addBinary(String a, String b) {
        String longer = a.length() > b.length() ? a : b;
        String shorter = a.length() > b.length() ? b : a;
        String result = "";
        int flag = 0;
        int i = longer.length() - 1;
        for (int j = shorter.length() - 1; j >= 0; j--) {
            int cal = longer.charAt(i) + shorter.charAt(j) + flag - 96;
            switch (cal) {
                case 0:result = "0" + result; flag = 0; break;
                case 1:result = "1" + result; flag = 0; break;
                case 2:result = "0" + result; flag = 1; break;
                case 3:result = "1" + result; flag = 1; break;
            }
            i--;
        }

        for ( ; i >= 0; i--) {
            if (i >= 0) {
                int cal = longer.charAt(i) + flag - 48;
                switch (cal) {
                    case 0:result = "0" + result; flag = 0; break;
                    case 1:result = "1" + result; flag = 0; break;
                    case 2:result = "0" + result; flag = 1; break;
                }
            }
        }

        if (flag == 1) {
            result = "1" + result;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(addBinary("100", "110010"));
    }
}
