package me.verzqli.leetcode.string;

import java.util.Arrays;

/**
 * <pre>
 *     author: Windows XP
 *     time  : 2019/5/15
 *     desc  : ���ַ����еĿո��滻��%20,���磬���ַ���ΪWe Are Happy.�򾭹��滻֮����ַ���ΪWe%20Are%20Happy��
 *     solve :�ȱ������ո���������������ӿո�*3�Ŀռ䣬Ȼ��Ӻ���ǰ���������ո��޸ĳ�%20
 *     problem:�����java�е�ȱ�ݣ������Ѿ�����һ��char���飬�����ɶ���Ŀռ䣬��Ȼ��Ҫ����new char[]���洢�µ����飬������ԭ��
 *     �����ϲ�������Խ��
 * </pre>
 */
public class ReplaceBlankInString {
    public static void main(String[] args) {
        char[] str;
        str = "HELLO WORLD HAHA".toCharArray();
        System.out.println("args = [" + replace(str, str.length) + "]");
    }

    public static String replace(char[] str, int length) {
        if (str == null || length <= 0) {
            return "";
        }
        int newIndex, oldIndex = 0, blankCount = 0;
        int i = 0;
        for (int j = 0; j < length; j++) {
            if (str[j] == ' ') {
                blankCount++;
            }
        }
        if (blankCount == 0) {
            return Arrays.toString(str);
        }
        int newLength = length + blankCount * 2;
        oldIndex = length - 1;
        char[] newArray = new char[newLength];
        newIndex = newLength - 1;
        while (oldIndex >= 0) {
            if (str[oldIndex] == ' ') {
                newArray[newIndex--] = '0';
                newArray[newIndex--] = '2';
                newArray[newIndex--] = '%';
                oldIndex--;
            } else {
                newArray[newIndex--] = str[oldIndex--];
            }
        }
        return Arrays.toString(newArray);

    }
}
