package me.verzqli.leetcode.everyday;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ����һ���� 0 �� 1 ��ɵľ����ҳ�ÿ��Ԫ�ص������ 0 �ľ��롣
 *
 * ��������Ԫ�ؼ�ľ���Ϊ 1 ��
 *
 * ʾ�� 1:
 * ����:
 *
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * ���:
 *
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * ʾ�� 2:
 * ����:
 *
 * 0 0 0
 * 0 1 0
 * 1 1 1
 * ���:
 *
 * 0 0 0
 * 0 1 0
 * 1 2 1
 * ע��:
 *
 * ���������Ԫ�ظ��������� 10000��
 * ����������������һ��Ԫ���� 0��
 * �����е�Ԫ��ֻ���ĸ�����������: �ϡ��¡����ҡ�
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/01-matrix
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class LeetCode20200415 {
    public static void main(String[] args) {
//        new LeetCode20200415().solve();
    }

    public int[][] solve(int[][] matrix) {
        //BFS������ȱ�������������Ľڵ������У����ݽ�����
        Queue<int[]> queue0 = new LinkedList<>();
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    queue0.offer(new int[]{i, j});
                } else {
                    matrix[i][j] = -1;
                }
            }
        }
        //�ĸ������xy�����ֵ���ֱ�����������
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        while (!queue0.isEmpty()) {
            int[] point = queue0.poll();
            for (int i = 0; i < 4; i++) {
                int newX = point[0] + dx[i];
                int newY = point[1] + dy[i];
                if (newX >= 0 && newX < row && newY >= 0 && newY < col && matrix[newX][newY] == -1) {
                    matrix[newX][newY] = matrix[point[0]][point[1]] + 1;
                    queue0.offer(new int[]{newX, newY});
                }
            }
        }
        return matrix;
    }

}
