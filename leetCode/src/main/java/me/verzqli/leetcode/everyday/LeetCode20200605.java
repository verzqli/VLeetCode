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
            //��ӡ������
            for (int i = left; i <= right; i++) {
                result[index++] = matrix[top][i];
            }
            //�ǲ������Ѿ������������
            if (++top > bottom) {
                break;
            }
            // ��ӡ���ϵ���
            for (int i = top; i <= bottom; i++) {
                result[index++] = matrix[i][right];
            }
            if (++right < left) {
                break;
            }
            //��ӡ���ҵ���
            for (int i = right; i >= left; i--) {
                result[index++] = matrix[bottom][i];
            }
            if (++bottom < top) {
                break;
            }
            //��ӡ���µ���
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
