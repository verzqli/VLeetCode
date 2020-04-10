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
        //这里有两种方式剪枝去重，一种是在最后对输出的字符串去重，
        //一种是这里对字符串里单个字符去重，这种方式可以减少运算循环。效果更好
        HashSet<Character> set = new HashSet<>();
        for (int i = index; i < chars.length; i++) {
            if (set.contains(chars[i])) {
                continue;
            }
            //交换后需要交换回来，当前交换不能对下一个交换产生影响
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
