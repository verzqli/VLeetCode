package com.young.offer;

import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，
 * 序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * （注意：这两个序列的长度是相等的）
 * <p>
 * 入栈1,2,3,4,5
 * <p>
 * 出栈4,5,3,2,1
 * <p>
 * 首先1入辅助栈，此时栈顶1≠4，继续入栈2
 * <p>
 * 此时栈顶2≠4，继续入栈3
 * <p>
 * 此时栈顶3≠4，继续入栈4
 * <p>
 * 此时栈顶4＝4，出栈4，弹出序列向后一位，此时为5，,辅助栈里面是1,2,3
 * <p>
 * 此时栈顶3≠5，继续入栈5
 * <p>
 * 此时栈顶5=5，出栈5,弹出序列向后一位，此时为3，,辅助栈里面是1,2,3
 */
public class Example22 {
    public static void main(String[] args) {
        System.out.printf("saa"+( new Example22().solve(new int[]{1,2,3,4,5},new int[]{4,3,5,1,2})));

    }

    public boolean solve(int[] pushArray, int[] popArray) {
        Stack<Integer> temp = new Stack<>();
        int pushIndex = 0;
        int popIndex = 0;
        while (pushIndex < pushArray.length) {
            //遍历压入数据入栈
            temp.push(pushArray[pushIndex]);
            //如果辅助栈不为空，且辅助栈顶等于出栈序列数据，就将这个辅助栈顶数据出栈，继续遍历第二个出栈序列数据。
            while (!temp.isEmpty() && (temp.peek() == popArray[popIndex])) {
                temp.pop();
                popIndex++;
            }
            pushIndex++;
        }
        return temp.isEmpty();
    }

}
