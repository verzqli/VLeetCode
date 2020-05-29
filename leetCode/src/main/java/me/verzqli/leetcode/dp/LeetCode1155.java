package me.verzqli.leetcode.dp;

/**
 * 1155. 掷骰子的N种方法
 * 这里有 d 个一样的骰子，每个骰子上都有 f 个面，分别标号为 1, 2, ..., f。
 * <p>
 * 我们约定：掷骰子的得到总点数为各骰子面朝上的数字的总和。
 * <p>
 * 如果需要掷出的总点数为 target，请你计算出有多少种不同的组合情况（所有的组合情况总共有 f^d 种），模 10^9 + 7 后返回。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：d = 1, f = 6, target = 3
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：d = 2, f = 6, target = 7
 * 输出：6
 * 示例 3：
 * <p>
 * 输入：d = 2, f = 5, target = 10
 * 输出：1
 * 示例 4：
 * <p>
 * 输入：d = 1, f = 2, target = 3
 * 输出：0
 * 示例 5：
 * <p>
 * 输入：d = 30, f = 30, target = 500
 * 输出：222616187
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= d, f <= 30
 * 1 <= target <= 1000
 */
public class LeetCode1155 {
    public static void main(String[] args) {
    }

    public int numRollsToTarget(int d, int f, int target) {
        int dp[][] = new int[d + 1][target+1];
        dp[0][0]=1;
        for (int i = 1; i <= d; i++) {
            for (int j = 1; j <= target - d + 1; j++) {
                for (int k = j; k <= target; k++) {
                    dp[i][k] = (dp[i][k] + dp[i - 1][k - j]) % 1000000007;
                }
            }
        }
        return dp[d][target];
    }

}
