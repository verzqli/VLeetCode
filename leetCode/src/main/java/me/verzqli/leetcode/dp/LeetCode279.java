package me.verzqli.leetcode.dp;

import java.util.Arrays;

/**
 * 279. 完全平方数
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 * 示例 2:
 * <p>
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 */
public class LeetCode279 {
    public static void main(String[] args) {
        new LeetCode279().numSquares(56);
    }

    public int numSquares(int n) {
        int sqrtNum = (int) Math.sqrt(n);
        if (sqrtNum * sqrtNum == n) {
            return 1;
        }
        int dp[] = new int[n + 1];
        Arrays.fill(dp,n+1);
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 1; i <= n; i++) {
            int sqrt = (int) Math.sqrt(i);
            for (int j = 1; j <= sqrt; j++) {
                if (sqrt * sqrt == i) {
                    dp[i] = 1;
                } else {
                    dp[i] =Math.min(dp[i],dp[j * j] + dp[i - j * j]);
                }

            }
        }
        return dp[n ];
    }

}
