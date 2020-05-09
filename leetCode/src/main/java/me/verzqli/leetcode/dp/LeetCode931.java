package me.verzqli.leetcode.dp;

/**
 * 给定一个方形整数数组?A，我们想要得到通过 A 的下降路径的最小和。
 * <p>
 * 下降路径可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列。
 * <p>
 * ?输入：[[1,2,3],[4,5,6],[7,8,9]]
 * 输出：1-4-7=12
 * 解释：
 * 可能的下降路径有：
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-falling-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
