package me.verzqli.leetcode.everyday;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author verzqli
 * @date 2020/7/4
 * @Desc
 */
class LeetCode20200704 {
    public int longestValidParentheses(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        int pre = 0;
        int cur = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') {
                if (deque.isEmpty()){
                    pre = 0;
                    continue;
                }
                while (i < s.length() && s.charAt(i) == ')' && !deque.isEmpty()) {
                    deque.pollLast();
                    cur += 2;
                    max = Math.max(max, cur);
                    i++;
                }
                if (s.isEmpty()){
                    cur += pre;
                    max = Math.max(max, cur);
                    pre  =cur;
                    cur = 0;
                }
                pre = 0;
            } else {
                deque.addLast(c);
            }

        }
        return max;
    }
}
