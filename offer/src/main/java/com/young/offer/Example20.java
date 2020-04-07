package com.young.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目:输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。例如:如果输入如下矩阵:
 * <p>
 * 1     2     3    4    5
 * <p>
 * 6     7     8    9   10
 * <p>
 * 11    12    13   14  15
 * <p>
 * 16    17    18   19  20
 * <p>
 * 输出就是1 ，2 ， 3 ， 4 ， 5 ， 10 ， 15  ，20 ，19  ，18  ，17 ， 16  ，11 ， 6 ， 7 ， 8  ，9  ，14 ， 13 12
 */
public class Example20 {
    public static void main(String[] args) {
        int[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        new Example20().solve(a);
    }

    public List<Integer> solve(int[][] array) {
        //任何题目最重要的就是数组边界
        if (array == null || array.length <= 0 || array[0].length <= 0) {
            return new ArrayList<>();
        }
        int row = array.length - 1;
        int col = array[0].length - 1;
        int start = 0;
        List<Integer> result = new ArrayList<>();
        //这里的row和col是数组下标，是从0开始的，这里比较的是行列数量，所以加回1
        while (row + 1 > start * 2 && col + 1 > start * 2) {
            result.addAll(printNumber(array, row, col, start));
            start++;
        }
        return result;
    }

    private List<Integer> printNumber(int[][] array, int row, int col, int round) {
        int endCol = col - round;
        int endRow = row - round;
        List<Integer> list = new ArrayList<>();
        //打印从左到右的边
        for (int i = round; i <= endCol; i++) {
            list.add(array[round][i]);
            System.out.printf(" " + array[round][i]);
        }
        if (round < endRow) {
            //打印从上到下的边
            for (int i = round + 1; i <= endRow; i++) {
                list.add(array[i][endRow]);
                System.out.printf(" " + array[i][endCol]);
            }
            if (round < endCol) {
                //打印从右到左的边，因为没有从上到下的边，从左到右也就无稽之谈，所以判断条件在里面
                for (int i = endCol - 1; i >= round; i--) {
                    list.add(array[endRow][i]);
                    System.out.printf(" " + array[endRow][i]);
                }

            }
        }
        //首先判断起始列小于数组列，因为这是画从右到左的边的条件，没有从右到左的边，从下到上的边也是无稽之谈，
        //第二个条件是判断有没有可供打印出的数字 例如1 3 4 想要有3 4的行号就必须比1大于等于2，所以这里加1
        if (round < endCol && round + 1 < endRow) {
            for (int i = endRow - 1; i >= round + 1; i--) {
                list.add(array[i][round]);
                System.out.printf(" " + array[i][round]);
            }
        }
        return list;

    }

}
