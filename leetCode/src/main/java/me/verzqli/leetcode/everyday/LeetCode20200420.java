package me.verzqli.leetcode.everyday;

/**
 * 200. 岛屿数量
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * <p>
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * <p>
 * 此外，你可以假设该网格的四条边均被水包围。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 * 输出: 3
 * 解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
 */
public class LeetCode20200420 {
    int row;
    int col;
    int x[] = {-1, 0, 1, 0};
    int y[] = {0, 1, 0, -1};

    public static void main(String[] args) {
    }
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        row = grid.length;
        col = grid[0].length;
        int isLandCount = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    isLandCount++;
                    bfs(grid, i, j);
                }
            }
        }
        return isLandCount;
    }

    private void bfs(char[][] grid, int i, int j) {
        if (grid[i][j] == '1') {
            grid[i][j] = '0';
            for (int k = 0; k < 4; k++) {
                int newX = i + x[k];
                int newY = j + y[k];
                if (newX >= 0 && newX < row && newY >= 0 && newY < col) {
                    bfs(grid, newX, newY);
                }
            }
        }
    }

}
