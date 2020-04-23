package me.verzqli.leetcode.knapsack;

/**
 * ������ͬ����Ӳ�Һ�һ���ܽ�д��������������Դճ��ܽ���Ӳ�������������ÿһ������Ӳ�������޸���?
 * <p>
 * ?
 * <p>
 * ʾ�� 1:
 * <p>
 * ����: amount = 5, coins = [1, 2, 5]
 * ���: 4
 * ����: �����ַ�ʽ���Դճ��ܽ��:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * ʾ�� 2:
 *
 * ����: amount = 3, coins = [2]
 * ���: 0
 * ����: ֻ�����2��Ӳ�Ҳ��ܴճ��ܽ��3��
 * ʾ�� 3:
 * <p>
 * ����: amount = 10, coins = [10]
 * ���: 1
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/coin-change-2
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class LeetCode518 {
    public static void main(String[] args) {
    }

    public int change(int amount, int[] coins) {
        int[] Farray = new int[amount + 1];
        Farray[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            int coin = coins[i];
            for (int j = coin; j <= amount; j++) {
                Farray[j] = Farray[j] + Farray[j - coin];
            }
        }
        return Farray[amount];
    }
}
