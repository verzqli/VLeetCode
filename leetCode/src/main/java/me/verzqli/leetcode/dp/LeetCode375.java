package me.verzqli.leetcode.dp;

/**
 * 375. �����ִ�С II
 * ����������һ��������Ϸ����Ϸ�������£�
 * <p>
 * �Ҵ� 1 �� n ֮��ѡ��һ�����֣���������ѡ���ĸ����֡�
 * <p>
 * ÿ����´��ˣ��Ҷ�������㣬��ѡ�����ֱ���Ĵ��˻���С�ˡ�
 * <p>
 * Ȼ��������������� x ���Ҳ´��˵�ʱ������Ҫ֧�����Ϊ x ���ֽ�ֱ����µ���ѡ�����֣������Ӯ���������Ϸ��
 * <p>
 * ʾ��:
 * <p>
 * n = 10, ��ѡ����8.
 * <p>
 * ��һ��: �����ѡ���������5���һ�����㣬�ҵ����ָ���һЩ��Ȼ������Ҫ֧��5�顣
 * �ڶ���: �����7���Ҹ����㣬�ҵ����ָ���һЩ����֧��7�顣
 * ������: �����9���Ҹ����㣬�ҵ����ָ�СһЩ����֧��9�顣
 * <p>
 * ��Ϸ������8 ������ѡ�����֡�
 * <p>
 * ������Ҫ֧�� 5 + 7 + 9 = 21 ��Ǯ��
 * ���� n �� 1��������������Ҫӵ�ж����ֽ����ȷ������Ӯ�������Ϸ��
 */
public class LeetCode375 {
    public static void main(String[] args) {
    }

    public int getMoneyAmount(int n) {
        int dp[][] = new int[n + 1][n + 1];
        for (int start = n; start >= 1; start--) {
            for (int end = start; end <= n; end++) {
                if (start == end) {
                    dp[start][end] = 0;
                } else {
                    dp[start][end] = Integer.MAX_VALUE;
                    for (int k = start; k <= end; k++) {
                        dp[start][end] = Math.min(dp[start][end], Math.max(dp[start][k - 1], dp[k + 1][end]) + k);
                    }
                }
            }
        }
        return dp[1][n];
    }

}
