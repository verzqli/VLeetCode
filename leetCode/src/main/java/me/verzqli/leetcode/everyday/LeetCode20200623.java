package me.verzqli.leetcode.everyday;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 67. ���������
 * ���������������ַ������������ǵĺͣ��ö����Ʊ�ʾ����
 * <p>
 * ����Ϊ �ǿ� �ַ�����ֻ�������� 1 �� 0��
 * <p>
 * ����: a = "11", b = "1"
 * ���: "100"
 */
class LeetCode20200623 {
    public static void main(String[] args) {
        new LeetCode20200623().addBinary("100", "110010");
    }

    public String addBinary(String a, String b) {
        int length = Math.min(a.length(), b.length());
        boolean isCarry = false;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < length; i++) {
            int a1 = a.charAt(a.length() - i - 1) - '0';
            int b1 = b.charAt(b.length() - i - 1) - '0';
            if (isCarry) {
                a1 += b1 + 1;
            } else {
                a1 += b1;
            }
            if (a1 >= 2) {
                deque.addLast(a1 - 2);
                isCarry = true;
            } else {
                deque.addLast(a1);
                isCarry = false;
            }
        }

        if (a.length() != b.length()) {
            String longStr = a.length() > b.length() ? a : b;
            for (int i = longStr.length() - length - 1; i >= 0; i--) {
                int n = longStr.charAt(i) - '0';
                if (isCarry) {
                    n += 1;
                }
                if (n == 2) {
                    deque.addLast(0);
                    isCarry = true;
                } else {
                    deque.addLast(n);
                    isCarry = false;
                }
            }
        }
        if (isCarry) {
            deque.addLast(1);
        }
        StringBuilder result = new StringBuilder();
        while (!deque.isEmpty()) {
            result.append(deque.pollLast());
        }
        return result.toString();
    }

}
