package com.rabbit.solution.easy;

import java.util.HashSet;
import java.util.Set;

public class Solution929 {
    public static int numUniqueEmails(String[] emails) {
        Set<String> hashset = new HashSet<>();
        for (int i = 0; i < emails.length; i++) {
            String newStr = "";
            String[] split = emails[i].split("@");
            String curr = split[0];
            curr = curr.replace(".", "");
            if (curr.contains("+"))
                curr = curr.substring(0, curr.indexOf("+"));
            newStr = curr + "@" + split[1];
            hashset.add(newStr);
        }

        return hashset.size();
    }

    public int numUniqueEmails2(String[] emails) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < emails.length; i++) {
            int indexOfPlus = emails[i].indexOf("+");
            int indexOfAt = emails[i].indexOf("@");
            String curr = emails[i].substring(0, indexOfPlus == -1 ? indexOfAt : indexOfPlus).replaceAll("\\.", "") + emails[i].substring(indexOfAt);
            set.add(curr);
        }

        return set.size();
    }

    public static void main(String[] args) {
        String[] testcase = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        System.out.println(numUniqueEmails(testcase));
    }
}
