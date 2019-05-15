package me.verzqli.leetcode.array;

import java.util.Arrays;

/**
 * <pre>
 *     author: Windows XP
 *     time  : 2019/5/15
 *     desc  : 把字符串中的空格替换成%20,例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 *     solve :先遍历出空格数量，给数组添加空格*3的空间，然后从后向前遍历，将空格修改成%20
 *     problem:这题对java有点缺陷，除非已经给定一个char数组，里面由多余的空间，不然就要重新new char[]来存储新的数组，不能在原来
 *     数组上操作，会越界
 * </pre>
 */
public class ReplaceBlankInString {
    public static void main(String[] args) {
        char[] str;
        str = "HELLO WORLD HAHA".toCharArray();
        System.out.println("args = [" + replace(str,str.length) + "]");
    }

    public static String replace(char[] str, int length) {
        if (str == null || length <= 0) {
            return "";
        }
        int newIndex, oldIndex = 0, blankCount = 0;
        int i = 0;
        for (int j = 0; j < length; j++) {
            if (str[j] == ' '){
                blankCount++;
            }
        }
        if (blankCount == 0) {
            return Arrays.toString(str);
        }
        int newLength = length + blankCount * 2;
        oldIndex = length-1;
       char [] newArray = new char[newLength];
        newIndex = newLength - 1;
        while (oldIndex >= 0 ) {
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
