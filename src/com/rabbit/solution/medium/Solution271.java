package com.rabbit.solution.medium;

import java.util.ArrayList;
import java.util.List;

public class Solution271 {
    public class Codec {

        // Encodes a list of strings to a single string.
        public String encode(List<String> strs) {
            if (strs.size() == 0) {
                return Character.toString((char) 258);
            }
            String spliter = Character.toString((char) 257);
            StringBuilder res = new StringBuilder();
            for (String s : strs) {
                res.append(s);
                res.append(spliter);
            }
            res.deleteCharAt(res.length() - 1);
            return res.toString();
        }

        // Decodes a single string to a list of strings.
        public List<String> decode(String s) {
            if (s.equals(Character.toString((char) 258))) {
                return new ArrayList<>();
            }
            List<String> res = new ArrayList<>();
            String spliter = Character.toString((char) 257);
            String[] strs = s.split(spliter, -1);
            for (String st : strs) {
                res.add(st);
            }
            return res;
        }
    }
}
