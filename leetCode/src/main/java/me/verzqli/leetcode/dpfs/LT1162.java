package me.verzqli.leetcode.dpfs;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author verzqli
 * @date 2020/6/27
 * @Desc
 */
class LT1162 {
    public static void main(String[] args) {
        new LT1162().maxDistance(new int[][]{{1,0,1},{0,0,0},{1,0,1}});
    }
    public int maxDistance(int[][] grid) {


        Deque<int[]> island = new ArrayDeque<>();
        int row = grid.length;
        int col = grid[0].length;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    island.add(new int[]{i, j});
                }
            }
        }
        if (island.size()==0||island.size()==row*col){
            return -1;
        }
        int step = 0;
        while (!island.isEmpty()) {
            int size = island.size();
            for (int i = 0; i < size; i++) {
                int[] landPoint = island.pollFirst();
                for (int j = 0; j < 4; j++) {
                    int curX = landPoint[0] + dx[j];
                    int curY = landPoint[1] + dy[j];
                    if (curX >= 0 && curX < row && curY >= 0 && curY < col && grid[curX][curY] == 0) {
                        grid[curX][curY] = 1;
                        island.add(new int[]{curX, curY});
                    }
                }
            }
            step++;
        }
        return step - 1;
    }

}
