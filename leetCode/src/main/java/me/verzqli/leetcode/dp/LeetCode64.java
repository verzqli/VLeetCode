package me.verzqli.leetcode.dp;

/**
 * 给定一个包含非负整数的 m?x?n?网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * <p>
 * 说明：每次只能向下或者向右移动一步。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 * ? [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
        //二维dp
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
        //一维dp
        int[] dp = new int[col];
        dp[0]=grid[0][0];
        for (int i = 1; i < col; i++) {
            dp[i] = dp[i-1]+grid[0][i];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (j==0){
                    //这里错误写成了dp[i]
                    dp[j] = dp[j-1>0?0:j-1]+grid[i][0];
                }else{
                    //min 第一个参数参考的是dp[j-1]而不是grid[i][j-1]
                    dp[j] = Math.min(dp[j-1],dp[j])+grid[i][j];
                }

            }
        }
        return dp[col-1];
    }

}
