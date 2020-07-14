package me.verzqli.leetcode.everyday;

import java.util.HashMap;
import java.util.Map;

class LeetCode20200712 {
    public int calculateMinimumHP(int[][] dungeon) {
        int row = dungeon.length;
        int col = dungeon[0].length;
        int dp[][] = new int[row][col];
        dp[row - 1][col - 1] = Math.min(dungeon[row - 1][col - 1], 0);
        for (int i = col - 2; i >= 0; i--) {
            //ͨ���׶���д��������ת������������д����
            int a = dungeon[row - 1][i] + dp[row - 1][i + 1];
            if (a > 0) {
                dp[row - 1][i] = 0;
            } else {
                dp[row - 1][i] = a;
            }

        }
        for (int i = row - 2; i >= 0; i--) {
            dp[i][col - 1] = Math.min(dungeon[i][col-1]+dp[i+1][col-1],0);
        }
        for (int i = row - 2; i >= 0; i--) {
            for (int j = col - 2; j >= 0; j--) {
                //�����ʼ�����maxд����min
                // ��Ϊ�ұߺ��±ߵ�dpֵҪ��Ϊ0��Ҫ��С��0������Ҫ�����С����ֵӦ����ȡ���ֵ
                dp[i][j] = Math.min(Math.max(dp[i][j + 1], dp[i + 1][j])+dungeon[i][j], 0);
            }
        }
        return  dp[0][0]>0?1:-dp[0][0]+1;
    }
}
