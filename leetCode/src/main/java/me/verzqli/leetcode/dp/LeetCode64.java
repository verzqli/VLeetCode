package me.verzqli.leetcode.dp;

/**
 * ����һ�������Ǹ������� m?x?n?�������ҳ�һ�������Ͻǵ����½ǵ�·����ʹ��·���ϵ������ܺ�Ϊ��С��
 * <p>
 * ˵����ÿ��ֻ�����»��������ƶ�һ����
 * <p>
 * ʾ��:
 * <p>
 * ����:
 * [
 * ? [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * ���: 7
 * ����: ��Ϊ·�� 1��3��1��1��1 ���ܺ���С��
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/minimum-path-sum
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class LeetCode64 {
    public static void main(String[] args) {
        new LeetCode64().minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}});
    }

    public int minPathSum(int[][] grid) {

        if (grid.length < 1) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        //��άdp
//        int[][] dp = new int[row][col];
//        dp[0][0]=grid[0][0];
//        for (int i = 1; i < row; i++) {
//            dp[i][0] =dp[i-1][0]+ grid[i][0];
//        }
//        for (int i = 1; i < col; i++) {
//            dp[0][i] =dp[0][i-1]+ grid[0][i];
//        }
//
//        for (int i = 1; i < row; i++) {
//            for (int j = 1; j < col; j++) {
//                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
//            }
//        }
//        return dp[row - 1][col - 1];
        //һάdp
        int[] dp = new int[col];
        dp[0]=grid[0][0];
        for (int i = 1; i < col; i++) {
            dp[i] = dp[i-1]+grid[0][i];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (j==0){
                    //�������д����dp[i]
                    dp[j] = dp[j-1>0?0:j-1]+grid[i][0];
                }else{
                    //min ��һ�������ο�����dp[j-1]������grid[i][j-1]
                    dp[j] = Math.min(dp[j-1],dp[j])+grid[i][j];
                }

            }
        }
        return dp[col-1];
    }

}
