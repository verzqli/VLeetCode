package me.verzqli.leetcode.Algorithm;

import java.io.Console;

/**
 * <pre>
 *     author: XuPei
 *     time  : 2019/10/9
 *     desc  :
 * </pre>
 */
public class NQueen {
    static final int QueenNum = 5;
    int Queen[] = new int[QueenNum];

    public static void main(String[] args) {
        new NQueen().start();
    }

    private void start() {
        Queen[0] = -1;
        int row = 0;
        int col = 0;
        int count = 0;
        while (true) {
            for (col = Queen[row] + 1; col < QueenNum; col++) {
                if (isOK(col, row)) {
                    break;
                }
            }
            if (col >= QueenNum) {//如果找到的列大于棋盘的范围
                //行为0时退出循环，不为0时则表示这一行不存在皇后，返回上一行找下一个皇后
                if (row == 0) {
                    break;
                } else {
                    Queen[row] = -1;
                    row--;
                }
            } else {
                Queen[row] = col;
                row++;
                if (row < QueenNum) {
                    Queen[row] = -1;
                } else {
                    count++;
                    print(count);
                    row--;
                }
            }
        }
    }

    public boolean isOK(int col, int row) {
        for (int i = 0; i < row; i++) {
            int queenCol = Queen[i];
            int span = row - i;
            if (col == queenCol || (col == queenCol + span) || (col == queenCol - span)) {
                return false;
            }
        }
        return true;
    }

    void print(int count) {
        System.out.println("第{" + (count) + "}种摆法：");
        for (int c = 0; c < QueenNum; c++) {
            for (int r = 0; r < QueenNum; r++) {
                if (r == Queen[c]) {
                    System.out.print(" Q ");
                } else {
                    System.out.print(" 0 ");
                }
            }
            System.out.println("\n");
        }
    }

}
