package com.rabbit.solution.medium;

public class Solution161 {
    // 遍历解法 推荐 注意return
    public boolean isOneEditDistance2(String s, String t) {
        int ns = s.length();
        int nt = t.length();
        if (ns > nt) {
            return isOneEditDistance2(t, s);
        }

        if (nt - ns > 1) {
            return false;
        }

        for (int i = 0; i < ns; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                return s.substring(i).equals(t.substring(i + 1)) || s.substring(i + 1).equals(t.substring(i)) || s.substring(i + 1).equals(t.substring(i + 1));
            }
        }

        return ns + 1 == nt;
    }

    // 递归解法 不是很推荐 corner case有点难处理
    public static boolean isOneEditDistance(String s, String t) {
        return helper(s, t, false);
    }

    public static boolean helper(String s, String t, boolean edited) {
        int i = 0;
        int j = 0;
        while (i < s.length() || j < t.length()) {
            if (i == s.length()) {
                return !edited && helper("", t.substring(j + 1), true);
            }
            if (j == t.length()) {
                return !edited && helper(s.substring(i + 1), "", true);
            }
            if (s.charAt(i) != t.charAt(j)) {
                if (!edited) {
                    return helper(s.substring(i), t.substring(i + 1), true)
                            || helper(s.substring(i + 1), t.substring(i), true)
                            || helper(s.substring(i + 1), t.substring(i + 1), true);
                } else {
                    return false;
                }
            }
            i++;
            j++;
        }
        return i == s.length() && j == t.length() && edited;
    }

    public static void main(String[] args) {
        isOneEditDistance("ab", "ab");
    }
}
