package com.rabbit.solution.hard;

public class Solution273 {
    public static String numberToWords(int num) {
        String numStr = String.valueOf(num);
        int length = numStr.length();
        int base = length;
        int level = 0;
        String res = "";
        while (base > 0) {
            res = convert(numStr.substring(base - 3 >= 0 ? base - 3: 0, base), level) + " " + res;
            res = res.trim();
            base -= 3;
            level++;
        }
        return res.trim();
    }

    public static String convert(String numStr, int level) {
        String[] single = {" Zero"," One"," Two"," Three"," Four"," Five"," Six"," Seven"," Eight"," Nine"};
        String[] ten1 = {" Ten"," Eleven"," Twelve"," Thirteen"," Fourteen"," Fifteen"," Sixteen"," Seventeen"," Eighteen"," Nineteen"};
        String[] ten2 = {"",""," Twenty"," Thirty"," Forty"," Fifty"," Sixty"," Seventy"," Eighty"," Ninety"};
        String res = "";
        if (numStr.length() == 1) {
            res += single[numStr.charAt(0) - '0'];
        } else if (numStr.length() == 2) {
            if (numStr.charAt(0) == '1') {
                res += ten1[numStr.charAt(1) - '0'];
            } else {
                res += ten2[numStr.charAt(0) - '0'];
                if (numStr.charAt(1) != '0') {
                    res += single[numStr.charAt(1) - '0'];
                }
            }
        } else {
            if (numStr.charAt(0) != '0'){
                res += single[numStr.charAt(0) - '0'];
                res += " Hundred";
            }

            if (numStr.charAt(1) == '1') {
                res += ten1[numStr.charAt(2) - '0'];
            } else if (numStr.charAt(1) == '0') {
                if (numStr.charAt(2) != '0')
                    res += single[numStr.charAt(2) - '0'];
            } else {
                res += ten2[numStr.charAt(1) - '0'];
                if (numStr.charAt(2) != '0') {
                    res += single[numStr.charAt(2) - '0'];
                }
            }
        }
        String[] str = res.trim().split(" ");
        if (res.trim().length() != 0) {
            switch (level){
                case 1: res += " Thousand"; break;
                case 2: res += " Million"; break;
                case 3: res += " Billion"; break;
            }
        }


        return res.trim();
    }

    public static void main(String[] args) {
        //System.out.println(convert("12",0));
        System.out.println(numberToWords(1000010));
    }
}
