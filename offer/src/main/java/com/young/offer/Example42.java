package com.young.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * [翻转单词顺序](https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof/)
 *
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。
 * 例如输入字符串"I am a student. "，则输出"student. a am I"。
 */
class Example42 {
    public static void main(String[] args) {
        new Example42().reverseWords("  hello world!  ");
    }

    public String reverseWords(String s) {
        List<StringBuilder> list = new ArrayList<>();
        StringBuilder item = new StringBuilder();
        boolean start = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                if (start) {
                    list.add(item);
                    item = new StringBuilder();
                    start = false;
                }
            } else {
                start = true;
                item.append(c);
            }
        }
        if (item.length() > 0) {
            list.add(item);
        }
        StringBuilder result = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            result.append(list.get(i));
            if (i != 0) {
                result.append(' ');
            }
        }
        return result.toString();
    }

}
