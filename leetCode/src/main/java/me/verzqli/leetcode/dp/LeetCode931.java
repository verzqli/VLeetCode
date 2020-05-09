package me.verzqli.leetcode.dp;

/**
 * ����һ��������������?A��������Ҫ�õ�ͨ�� A ���½�·������С�͡�
 * <p>
 * �½�·�����Դӵ�һ���е��κ�Ԫ�ؿ�ʼ������ÿһ����ѡ��һ��Ԫ�ء�����һ��ѡ���Ԫ�غ͵�ǰ����ѡԪ��������һ�С�
 * <p>
 * ?���룺[[1,2,3],[4,5,6],[7,8,9]]
 * �����1-4-7=12
 * ���ͣ�
 * ���ܵ��½�·���У�
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/minimum-falling-path-sum
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class LeetCode931 {
    public static void main(String[] args) {
        new LeetCode931().minFallingPathSum(new int[][]{{-80, -35, 74}, {-62, 14, -53}, {94, 61, -10}});
    }

    public int minFallingPathSum(int[][] grid) {
        int[][] dp = new int[2][grid[0].length];
        int row = grid.length;
        int col = grid[0].length;
        int k = 1;
        for (int i = 0; i < row; i++) {
            k = Math.abs(k-1);
            for (int j = 0; j < col; j++) {
                if (i==0){
                    dp[k][j]=grid[i][j];
                }else  if (j==0){
                    dp[k][j] = Math.min(dp[1-k][j],dp[1-k][Math.min(j+1,col-1)])+grid[i][j];
                }else if (j==col-1){
                    dp[k][j] = Math.min(dp[1-k][j-1],dp[1-k][j])+grid[i][j];
                }else{
                    dp[k][j] = Math.min(dp[1-k][j-1],Math.min(dp[1-k][j],dp[1-k][j+1]))+grid[i][j];
                }
            }
        }
        int result = dp[k][0];
        for (int i = 0; i < col; i++) {
            result = Math.min(result, dp[k][i]);
        }
        return result;
    }

}
