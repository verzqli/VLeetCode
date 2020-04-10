package com.young.offer;

import java.util.Arrays;
import java.util.HashSet;

public class Example28 {
    StringBuilder builder = new StringBuilder();
    char[] chars;

    public static void main(String[] args) {
        new Example28().solve("112");
    }

    public void solve(String s) {
        chars = s.toCharArray();
        dfs(0);

    }

    private void dfs(int index) {
        if (index == chars.length - 1) {
            System.out.println(Arrays.toString(chars));
            return;
        }
        //���������ַ�ʽ��֦ȥ�أ�һ����������������ַ���ȥ�أ�
        //һ����������ַ����ﵥ���ַ�ȥ�أ����ַ�ʽ���Լ�������ѭ����Ч������
        HashSet<Character> set = new HashSet<>();
        for (int i = index; i < chars.length; i++) {
            if (set.contains(chars[i])) {
                continue;
            }
            //��������Ҫ������������ǰ�������ܶ���һ����������Ӱ��
            set.add(chars[index]);
            swap(chars, index, i);
            dfs(index + 1);
            swap(chars, index, i);
        }
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

}
