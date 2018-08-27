package com.rabbit.solution.easy;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class Solution401 {
    public static List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                String hour = String.format("%04d", Integer.parseInt(Integer.toBinaryString(i)));
                if (hour.equals("0011")) {
                    System.out.println("wow");
                }
                String minute = String.format("%06d", Integer.parseInt(Integer.toBinaryString(j)));
                if (getOne(hour) + getOne(minute) == num) {
                    String strH = getTime(hour);
                    String strM = getTime(minute);
                    if (strH != null && strM != null) {
                        res.add(strH + ":" + strM);
                    }
                }
            }
        }
        return res;
    }

    public static String getTime(String n) {
        int sum = 0;
        if (n.length() == 4) {
            // 时
            for (int i = 0; i < n.length(); i++) {
                if (n.charAt(i) == '1') {
                    sum += Math.pow(2, 3 - i);
                }
            }
            if (sum > 11) {
                return null;
            }
            return String.valueOf(sum);
        } else if (n.length() == 6) {
            // 分
            for (int i = 0; i < n.length(); i++) {
                if (n.charAt(i) == '1') {
                    sum += Math.pow(2, 5 - i);
                }
            }
            if (sum > 59) {
                return null;
            }
            String res = String.valueOf(sum);
            return res.length() == 1 ? "0" + res : res;
        }

        return null;
    }

    public static int getOne(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(readBinaryWatch(2).toString());
        String[] str1 = {"0:48","0:40","0:24","0:36","0:20","0:12","0:34","0:18","0:10","0:06","0:33","0:17","0:09","0:05","0:03","8:32","8:16","8:08","8:04","8:02","8:01","4:32","4:16","4:08","4:04","4:02","4:01","2:32","2:16","2:08","2:04","2:02","2:01","10:00","6:00","1:32","1:16","1:08","1:04","1:02","1:01","9:00","5:00"};
        String[] str2 = {"0:03","0:05","0:06","0:09","0:10","0:12","0:17","0:18","0:20","0:24","0:33","0:34","0:36","0:40","0:48","1:01","1:02","1:04","1:08","1:16","1:32","2:01","2:02","2:04","2:08","2:16","2:32","3:00","4:01","4:02","4:04","4:08","4:16","4:32","5:00","6:00","8:01","8:02","8:04","8:08","8:16","8:32","9:00","10:00"};
        for (int i = 0; i < str2.length; i++) {
            boolean flag = false;
            for (int j = 0; j < str1.length; j++) {
                if (str2[i] == str1[j]) {
                    flag = true;
                }
            }

            if (!flag) {
                System.out.println(str2[i]);
            }
        }
    }
}
