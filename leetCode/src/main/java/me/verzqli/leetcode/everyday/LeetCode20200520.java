package me.verzqli.leetcode.everyday;

import java.util.Arrays;

public class LeetCode20200520 {
    public static void main(String[] args) {
        new LeetCode20200520().findTheLongestSubstring("lzzziaae");
    }

    public int findTheLongestSubstring(String s) {
        int length = s.length();
        int dp[] = new int[(1 << 5)];
        //把数组用-1填充，区分00000的情况
        Arrays.fill(dp, -1);
        dp[0] = 0;
        int result = 0, flag = 0;
        for (int i = 0; i < length; i++) {
            char a = s.charAt(i);
            if (a == 'a') {
                flag ^= (1 << 0);
            } else if (a == 'e') {
                flag ^= (1 << 1);
            } else if (a == 'i') {
                flag ^= (1 << 2);
            } else if (a == 'o') {
                flag ^= (1 << 3);
            } else if (a == 'u') {
                flag ^= (1 << 4);
            }
            if (dp[flag] >= 0) {
                result = Math.max(result, i - dp[flag]);
            } else {
                dp[flag] = i;
            }
        }
        return result;
    }
}

