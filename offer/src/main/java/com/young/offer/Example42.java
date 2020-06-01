package com.young.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * [��ת����˳��](https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof/)
 *
 * ����һ��Ӣ�ľ��ӣ���ת�����е��ʵ�˳�򣬵��������ַ���˳�򲻱䡣Ϊ������������ź���ͨ��ĸһ������
 * ���������ַ���"I am a student. "�������"student. a am I"��
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
