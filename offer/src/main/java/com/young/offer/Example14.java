package com.young.offer;

import java.util.Arrays;

/**
 * 题目：输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 * <p>
 * 思路：设置头尾指针，头指针向后移动，找到一个偶数后与尾指针的奇数互换，然后两者各前进一步，最后当尾指针位置index小于头指针时则说明分拣完毕。
 */
public class Example14 {
    public static void main(String[] args) {
        System.out.println("args = " + Arrays.toString(new Example14().solve(new int[]{2, 4, 6, 8, 10})));

    }

    public int[] solve(int[] array) {
        if (array.length == 0) {
            return null;
        }
        if (array.length == 1) {
            return array;
        }
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            //前面这个start<end是为了防止全是偶数或者奇数导致的数组下标溢出
            while ((start < end) && (array[start] & 1) == 1) {
                start++;
            }
            while ((start < end) && (array[end] & 1) != 1) {
                end--;
            }
            if (start < end) {
                int temp = array[start];
                array[start] = array[end];
                array[end] = temp;
            }
        }
        return array;
    }

}
