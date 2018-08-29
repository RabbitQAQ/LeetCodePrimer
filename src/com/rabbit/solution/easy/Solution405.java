package com.rabbit.solution.easy;

public class Solution405 {
    public static String toHex(int num) {
        if (num == 0) {
            return "0";
        }

        String[] words = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};
        StringBuffer res = new StringBuffer();
        for (int i = 0; i < 8; i++) {
            int temp = num & 0xf;
            res.append(words[temp]);
            num >>= 4;
        }
        res = res.reverse();
        while (true) {
            if (res.charAt(0) == '0') {
                res.deleteCharAt(0);
            } else {
                break;
            }
        }
        return res.toString();
    }

    private static char[] map = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

    public static String toHex2(int num) {
        if(num==0) return "0";
        String res = "";
        while(num!=0){
            res = map[num&15] + res;
            num = (num>>>4);
        }
        return res;
    }

    public static void main(String[] args) {
        int num = -1;
        System.out.println(toHex2(16));
    }
}
