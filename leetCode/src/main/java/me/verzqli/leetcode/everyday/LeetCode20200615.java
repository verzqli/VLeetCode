package me.verzqli.leetcode.everyday;

import java.util.Arrays;

public class LeetCode20200615 {
    public static void main(String[] args) {
        System.out.println("args = "+ (new LeetCode20200615().longestCommonPrefix(new String[]{"c", "c"})));

    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        int count = 0;
        int len = strs.length;
        int firstLen = strs[0].length();
        while (firstLen > count) {
            char a = strs[0].charAt(count);
            for (int i = 1; i < len; i++) {
                if (strs[i].length() > count) {
                    if (strs[i].charAt(count) != a) {
                        return count == 0 ? "" : strs[0].substring(0,count);
                    }
                } else {
                    return count == 0 ? "" : strs[0].substring(0,count);
                }
            }
            count++;
        }
        return count == 0 ? "" : strs[0].substring(0,count);
    }

}
