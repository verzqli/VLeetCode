package me.verzqli.leetcode.dp;

import java.util.Arrays;

/**
 * ������ͬ����Ӳ�� coins ��һ���ܽ�� amount����дһ��������������Դճ��ܽ����������ٵ�Ӳ�Ҹ�����
 * ���û���κ�һ��Ӳ�����������ܽ�����?-1��
 * <p>
 * ?
 * <p>
 * ʾ��?1:
 * <p>
 * ����: coins = [1, 2, 5], amount = 11
 * ���: 3
 * ����: 11 = 5 + 5 + 1
 * ʾ�� 2:
 * <p>
 * ����: coins = [2], amount = 3
 * ���: -1
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/coin-change
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class LeetCode322 {
    public static void main(String[] args) {
        new LeetCode322().coinChange(new int[]{1,2,5},11);
    }

    public int coinChange(int[] coins, int amount) {
        if (amount==0||coins.length<1){
            return 0;
        }
        int dp[] = new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0]=0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i-coins[j]>=0){
                    dp[i] =Math.min(dp[i],dp[i - coins[j]]+1) ;
                }
            }
        }
        return dp[amount]!=(amount+1)?dp[amount]:-1;
    }

}
