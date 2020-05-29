package me.verzqli.leetcode.dp;

/**
 * 1155. �����ӵ�N�ַ���
 * ������ d ��һ�������ӣ�ÿ�������϶��� f ���棬�ֱ���Ϊ 1, 2, ..., f��
 * <p>
 * ����Լ���������ӵĵõ��ܵ���Ϊ�������泯�ϵ����ֵ��ܺ͡�
 * <p>
 * �����Ҫ�������ܵ���Ϊ target�����������ж����ֲ�ͬ�������������е��������ܹ��� f^d �֣���ģ 10^9 + 7 �󷵻ء�
 * <p>
 * <p>
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺d = 1, f = 6, target = 3
 * �����1
 * ʾ�� 2��
 * <p>
 * ���룺d = 2, f = 6, target = 7
 * �����6
 * ʾ�� 3��
 * <p>
 * ���룺d = 2, f = 5, target = 10
 * �����1
 * ʾ�� 4��
 * <p>
 * ���룺d = 1, f = 2, target = 3
 * �����0
 * ʾ�� 5��
 * <p>
 * ���룺d = 30, f = 30, target = 500
 * �����222616187
 * <p>
 * <p>
 * ��ʾ��
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
