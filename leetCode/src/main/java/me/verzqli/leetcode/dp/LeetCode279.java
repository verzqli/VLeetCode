package me.verzqli.leetcode.dp;

import java.util.Arrays;

/**
 * 279. ��ȫƽ����
 * ���������� n���ҵ����ɸ���ȫƽ���������� 1, 4, 9, 16, ...��ʹ�����ǵĺ͵��� n������Ҫ����ɺ͵���ȫƽ�����ĸ������١�
 * <p>
 * ʾ�� 1:
 * <p>
 * ����: n = 12
 * ���: 3
 * ����: 12 = 4 + 4 + 4.
 * ʾ�� 2:
 * <p>
 * ����: n = 13
 * ���: 2
 * ����: 13 = 4 + 9.
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
