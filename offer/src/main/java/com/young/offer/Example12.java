package com.young.offer;

import java.util.Arrays;

/**
 * 输入数字n，按顺序打印出从1最大的n位十进制数。比如输入3，则打印出1、2、3-直到最大的3位数即999。
 */
public class Example12 {
    StringBuilder str = new StringBuilder();

    public static void main(String[] args) {
        new Example12().solve(2);
    }

    public void solve(int n) {
        if (n == 0) {
            System.out.printf("0");
            return;
        }
        int[] number = new int[n + 1];
        number[n] = 0;
        while (!increment(number)) {
            printNumber(number);
        }
    }

    private void printNumber(int[] array) {
        str.setLength(0);
        boolean isFirstNotZero = true;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0 && isFirstNotZero) {
                isFirstNotZero = false;
            }
            if (!isFirstNotZero){
                str.append(array[i]);
            }
        }
        System.out.println(str.toString());

    }

    private boolean increment(int[] array) {
        int sum = 0;
        boolean isOver = false;
        boolean isEnd = false;
        for (int i = array.length - 1; i >= 0; i--) {
            sum = array[i];
            if (i == array.length - 1) {
                sum++;
            }
            if (isOver) {
                sum++;
            }
            if (i == 0) {
                isEnd = isOver;
            } else {
                if (sum >= 10) {
                    isOver = true;
                    sum -= 10;
                } else {
                    isOver = false;
                }
                array[i] = sum;
            }
        }
        return isEnd;
    }

}
