package me.verzqli.leetcode.everyday;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
 *
 * 两个相邻元素间的距离为 1 。
 *
 * 示例 1:
 * 输入:
 *
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * 输出:
 *
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * 示例 2:
 * 输入:
 *
 * 0 0 0
 * 0 1 0
 * 1 1 1
 * 输出:
 *
 * 0 0 0
 * 0 1 0
 * 1 2 1
 * 注意:
 *
 * 给定矩阵的元素个数不超过 10000。
 * 给定矩阵中至少有一个元素是 0。
 * 矩阵中的元素只在四个方向上相邻: 上、下、左、右。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/01-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode20200415 {
    public static void main(String[] args) {
//        new LeetCode20200415().solve();
    }

    public int[][] solve(int[][] matrix) {
        //BFS广度优先遍历，将遍历后的节点加入队列，层层递进遍历
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
        //四个方向的xy轴差量值，分别是上下左右
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
