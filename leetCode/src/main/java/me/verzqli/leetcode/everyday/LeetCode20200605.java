package me.verzqli.leetcode.everyday;

public class LeetCode20200605 {
    public static void main(String[] args) {
    }

    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }
        int[] result = new int[matrix.length * matrix[0].length];
        int top = 0, left = 0, right = matrix[0].length - 1, bottom = matrix.length - 1;
        int index = 0;
        while (true) {
            //打印从左到右
            for (int i = left; i <= right; i++) {
                result[index++] = matrix[top][i];
            }
            //角部数字已经在上面包括了
            if (++top > bottom) {
                break;
            }
            // 打印从上到下
            for (int i = top; i <= bottom; i++) {
                result[index++] = matrix[i][right];
            }
            if (++right < left) {
                break;
            }
            //打印从右到左
            for (int i = right; i >= left; i--) {
                result[index++] = matrix[bottom][i];
            }
            if (++bottom < top) {
                break;
            }
            //打印从下到上
            for (int i = bottom; i >= top; i--) {
                result[index++] = matrix[i][left];
            }
            if (++left > right) {
                break;
            }
        }
        return result;
    }

}
