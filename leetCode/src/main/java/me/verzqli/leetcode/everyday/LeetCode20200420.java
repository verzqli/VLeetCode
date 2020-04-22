package me.verzqli.leetcode.everyday;

/**
 * 200. ��������
 * ����һ���� '1'��½�أ��� '0'��ˮ����ɵĵĶ�ά����������������е����������
 * <p>
 * �������Ǳ�ˮ��Χ������ÿ������ֻ����ˮƽ�����/����ֱ���������ڵ�½�������γɡ�
 * <p>
 * ���⣬����Լ��������������߾���ˮ��Χ��
 * <p>
 * ʾ�� 1:
 * <p>
 * ����:
 * 11110
 * 11010
 * 11000
 * 00000
 * ���: 1
 * ʾ�� 2:
 * <p>
 * ����:
 * 11000
 * 11000
 * 00100
 * 00011
 * ���: 3
 * ����: ÿ������ֻ����ˮƽ��/����ֱ���������ڵ�½�����Ӷ��ɡ�
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
